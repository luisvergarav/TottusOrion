package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.eventgrid.azure;


import com.microsoft.azure.management.eventhub.EventHub;
import com.microsoft.azure.management.eventhub.EventHubAuthorizationRule;
import com.microsoft.azure.management.eventhub.EventHubNamespace;
import com.microsoft.azure.management.eventhub.EventHubNamespaceSkuType;
import com.microsoft.azure.management.eventhub.implementation.EventHubManager;

import com.microsoft.azure.eventhubs.EventData;
import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.EventHubRuntimeInformation;
import com.microsoft.azure.eventhubs.EventPosition;
import com.microsoft.azure.eventhubs.PartitionReceiver;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.utils.SdkContext;

import com.microsoft.rest.LogLevel;
import org.joda.time.DateTime;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Azure Event Grid sample for publishing and consuming custom events
 *   - Create a resource group.
 *   - Create an Azure EventHub resource which will be used for receiving and pulling the events.
 *   - Create an Azure EventGrid topic;
 *   - Create an EventGrid Subscription with EventHub destination.
 *   - Create an EventGrid client object and use it to publish custom events to the EventGrid
 *   - Create an EventHub client and use it to pull/receive the custom events from the EventGrid via a PartitionReceiver.
 */
public class AzureEventGridIncommingMessageListener {
	

    private static EventHubManager eventHubManager;
    
    /**
     * Main function which runs the actual sample.
     * @return true if sample runs successfully
     */
    public static boolean runSample() {

          final String eventHubRuleName = "ehRule1";
          final String eventSubscriptionName = "EventSubscription1";
          final String rgName = SdkContext.randomResourceName("rgeventgrid", 24);
          final String eventHubNamespaceName = SdkContext.randomResourceName("ehns", 24);
          final String defaultRegion = Region.US_WEST.label();

        try {

          
        	 //============================================================
            // Create an event hub.
            //
            System.out.println("Creating an Azure EventHub");

            EventHubNamespace eventHubNamespace = eventHubManager.namespaces().define(eventHubNamespaceName)
                .withRegion(defaultRegion)
                .withExistingResourceGroup(rgName)
                .withAutoScaling()
                .withSku(EventHubNamespaceSkuType.STANDARD)
                .withNewEventHub("eh1", 2, 1)
                .withNewManageRule("rule1")
                .withTag("key1", "value1")
                .create();

            System.out.println("EventHub namespace created with name " + eventHubNamespace.name());

            EventHub eventHub = eventHubNamespace.listEventHubs().get(0);
            System.out.println("EventHub created with name " + eventHub.name());

            System.out.println("EventHub update with new managed rule");
            eventHub.update()
                .withNewManageRule(eventHubRuleName)
                .apply();

            
            
        	 // Create an EventHub client.
            //

            System.out.println("Creating an Azure EventHub Client");
            EventHubAuthorizationRule eventHubRule = eventHub.listAuthorizationRules().get(0);
            if (!eventHubRule.name().equals(eventHubRuleName)) {
                return false;
            }
            final String eventHubConnectionString = eventHubRule.getKeys().primaryConnectionString();
            final ExecutorService executorService = Executors.newSingleThreadExecutor();
            final EventHubClient ehClient = EventHubClient.createSync(eventHubConnectionString, (ScheduledExecutorService) executorService);
            final EventHubRuntimeInformation eventHubInfo = ehClient.getRuntimeInformation().get();
            System.out.format("EventHub Runtime information\n\tpath: %s\n\tpartition count: %d\n\tcreated at: %s\n", eventHubInfo.getPath(), eventHubInfo.getPartitionCount(), eventHubInfo.getCreatedAt().toString());

            System.out.println("Done creating an Azure EventHub Client...");

         
          
          
            //============================================================
            // Receive custom events from the EventGrid.
            //

            System.out.println("Receive custom events from the EventGrid");

      
                for (int idx = 0; idx < eventHubInfo.getPartitionCount(); idx++) {
                    final String partitionId = eventHubInfo.getPartitionIds()[idx]; // get first partition's id

                    final PartitionReceiver receiver = ehClient.createEpochReceiverSync(
                        EventHubClient.DEFAULT_CONSUMER_GROUP_NAME,
                        partitionId,
                        EventPosition.fromStartOfStream(),
                        2345);

                    System.out.println("receiver created from sequenceNumber...");

                    int receivedCount = 0;
                    while (receivedCount++ < 1) {
                        receiver.receive(10)
                            .thenAcceptAsync(receivedEvents -> {
                                int batchSize = 0;
                                if (receivedEvents != null) {
                                    for (EventData receivedEvent : receivedEvents) {
                                        System.out.print(String.format("Offset: %s, SeqNo: %s, EnqueueTime: %s",
                                            receivedEvent.getSystemProperties().getOffset(),
                                            receivedEvent.getSystemProperties().getSequenceNumber(),
                                            receivedEvent.getSystemProperties().getEnqueuedTime()));

                                        if (receivedEvent.getBytes() != null)
                                            System.out.println(String.format("| Message Payload: %s", new String(receivedEvent.getBytes(), Charset.defaultCharset())));
                                        batchSize++;
                                    }
                                }

                                System.out.println(String.format("ReceivedBatch Size: %s", batchSize));
                            }, executorService).get();
                    }
                    // cleaning up receivers is paramount;
                    // Quota limitation on maximum number of concurrent receivers per consumergroup per partition is 5
//                    receiver.closeSync();
//                        .thenComposeAsync(aVoid -> ehClient.close(), executorService)
//                        .whenCompleteAsync((t, u) -> {
//                            if (u != null) {
//                                // wire-up this error to diagnostics infrastructure
//                                System.out.println(String.format("closing failed with error: %s", u.toString()));
//                            }
//                        }, executorService).get();
//                }
//            } finally {
//                ehClient.closeSync();
//                executorService.shutdown();
//            }
//            System.out.println("Done receive custom events from the EventGrid");
                }
            return true;
             
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            
        }
        return false;
    }

  


    /**
     * Main entry point.
     * @param args the parameters
     */
    public static void main(String[] args) {
        try {
            //=============================================================
            // Authenticate

        
         

//            eventGridManager = EventGridManager
//                .configure()
//                .withLogLevel(LogLevel.BASIC)
//                .authenticate(credentials, credentials.defaultSubscriptionId());

            // Print selected subscription
        //    System.out.println("Selected subscription: " + credentials.defaultSubscriptionId());

            runSample();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}