package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.eventgrid.azure;

import com.microsoft.azure.eventgrid.EventGridClient;
import com.microsoft.azure.eventgrid.TopicCredentials;
import com.microsoft.azure.eventgrid.implementation.EventGridClientImpl;
import com.microsoft.azure.eventgrid.models.EventGridEvent;

import com.microsoft.azure.management.eventgrid.v2018_01_01.EventSubscription;
import com.microsoft.azure.management.eventgrid.v2018_01_01.EventSubscriptionFilter;
import com.microsoft.azure.management.eventgrid.v2018_01_01.Topic;
import com.microsoft.azure.management.eventgrid.v2018_01_01.implementation.EventGridManager;

import com.microsoft.rest.LogLevel;
import org.joda.time.DateTime;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Azure Event Grid sample for publishing and consuming custom events
 *   - Create a resource group.
 *   - Create an Azure EventHub resource which will be used for receiving and pulling the events.
 *   - Create an Azure EventGrid topic;
 *   - Create an EventGrid Subscription with EventHub destination.
 *   - Create an EventGrid client object and use it to publish custom events to the EventGrid
 *   - Create an EventHub client and use it to pull/receive the custom events from the EventGrid via a PartitionReceiver.
 */
public class AzureEventGridIncommingMessageProducer {

    private static EventGridClient eventGridClient;

    /**
     * Main function which runs the actual sample.
     * @return true if sample runs successfully
     */
    public static boolean runSample() {

          final String eventHubRuleName = "ehRule1";
          final String eventSubscriptionName = "EventSubscription1";

        try {

        	
        	
        	
          
            //============================================================
            // Create an event grid subscription.
            //
//            System.out.println("Creating an Azure EventGrid Subscription");
//
//            EventSubscription eventSubscription = eventGridManager.eventSubscriptions().define(eventSubscriptionName)
//                .withScope(eventGridTopic.id())
//                .withDestination(new EventHubEventSubscriptionDestination()
//                    .withResourceId(eventHub.id()))
//                .withFilter(new EventSubscriptionFilter()
//                    .withIsSubjectCaseSensitive(false)
//                    .withSubjectBeginsWith("")
//                    .withSubjectEndsWith(""))
//                .create();
//
//            System.out.println("EventGrid event subscription created with name " + eventSubscription.name());

            //============================================================
            // Retrieve the event grid client connection key.
            //
//            System.out.println("Retrieve the event grid client connection key");
//
            String eventGridClientKey = "387dB+6CxgeO4940/EOM2OXRGs08mtSVo5eKc7bo9K0=";// eventGridManager.topics().listSharedAccessKeysAsync(rgName, topicName).toBlocking().last().key1();
//
//            System.out.format("Found EventGrid client connection key \"%s\" for endpoint \"%s\"\n", eventGridClientKey, eventGridTopic.endpoint());

            //============================================================
            // Create an event grid client.
            //
            System.out.println("Creating an Azure EventGrid Client");

            TopicCredentials topicCredentials = new TopicCredentials(eventGridClientKey);
            EventGridClient client = new EventGridClientImpl(topicCredentials);


            String eventGridEndpoint = "https://orion-pe-test-topic.brazilsouth-1.eventgrid.azure.net/api/events";
            String topicHostname = new URI(eventGridEndpoint).getHost();
            System.out.println("Done creating an Azure EventGrid Client...");

            //============================================================
            // Publish custom events to the EventGrid.
            //

            System.out.println("Publish custom events to the EventGrid");
            List<EventGridEvent> eventsList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                eventsList.add(new EventGridEvent(
                    com.microsoft.azure.arm.utils.SdkContext.randomUuid(),
                    String.format("Door%d", i),
                    new ContosoItemReceivedEventData("Contoso Item SKU #1"),
                    "ProductCreatedEvent",
                    DateTime.now(),
                    "2.0"
                ));
            }


            client.publishEvents(topicHostname, eventsList);

            System.out.println("Done publishing custom events to the EventGrid");

          
            //============================================================
            // Receive custom events from the EventGrid.
            //
//
//            System.out.println("Receive custom events from the EventGrid");
//
//            try {
//                for (int idx = 0; idx < eventHubInfo.getPartitionCount(); idx++) {
//                    final String partitionId = eventHubInfo.getPartitionIds()[idx]; // get first partition's id
//
//                    final PartitionReceiver receiver = ehClient.createEpochReceiverSync(
//                        EventHubClient.DEFAULT_CONSUMER_GROUP_NAME,
//                        partitionId,
//                        EventPosition.fromStartOfStream(),
//                        2345);
//
//                    System.out.println("receiver created from sequenceNumber...");
//
//                    int receivedCount = 0;
//                    while (receivedCount++ < 1) {
//                        receiver.receive(10)
//                            .thenAcceptAsync(receivedEvents -> {
//                                int batchSize = 0;
//                                if (receivedEvents != null) {
//                                    for (EventData receivedEvent : receivedEvents) {
//                                        System.out.print(String.format("Offset: %s, SeqNo: %s, EnqueueTime: %s",
//                                            receivedEvent.getSystemProperties().getOffset(),
//                                            receivedEvent.getSystemProperties().getSequenceNumber(),
//                                            receivedEvent.getSystemProperties().getEnqueuedTime()));
//
//                                        if (receivedEvent.getBytes() != null)
//                                            System.out.println(String.format("| Message Payload: %s", new String(receivedEvent.getBytes(), Charset.defaultCharset())));
//                                        batchSize++;
//                                    }
//                                }
//
//                                System.out.println(String.format("ReceivedBatch Size: %s", batchSize));
//                            }, executorService).get();
//                    }
//                    // cleaning up receivers is paramount;
//                    // Quota limitation on maximum number of concurrent receivers per consumergroup per partition is 5
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

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            
        }
        return false;
    }

    /**
     * This captures the "Data" portion of an EventGridEvent on a custom topic
     */
    static class ContosoItemReceivedEventData
    {
        public String itemSku;

        public ContosoItemReceivedEventData(String itemSku) {
            this.itemSku = itemSku;
        }
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