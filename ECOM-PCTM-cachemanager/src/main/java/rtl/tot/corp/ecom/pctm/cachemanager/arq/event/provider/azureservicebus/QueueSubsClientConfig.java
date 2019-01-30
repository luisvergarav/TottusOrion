package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.azureservicebus;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.microsoft.azure.servicebus.MessageHandlerOptions;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.EventHandler;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.EventSubscriber;

//@Slf4j
//public class QueueSubsClientConfig implements EventSubscriber {
//
//	private QueueClient queueClient;
//		
//    @Value("${azure.servicebus.connection-string}")
//    private String endpoint;
//
//    @Value("${azure.servicebus.queue-name}")
//    private String queue;
//
//    @Value("${azure.servicebus.queue-receive-mode}")
//    private ReceiveMode receiveMode;
//    
//  
//    
//	@PostConstruct
//	void postConstruct() throws InterruptedException, ServiceBusException {
//
//		queueClient = new QueueClient(new ConnectionStringBuilder(
//				endpoint, queue),
//				receiveMode);
//	}
//
//	@Override
//	public boolean registerEventHandler(EventHandler eventHandler) {
//	    if (eventHandler == null) {
//            return false;
//        }
//
//        boolean registeredEventHandler = false;
//        try {
//        	  queueClient.registerMessageHandler(
//        			  new AzureQueueMessageHandler(queueClient, eventHandler));
//            
//            registeredEventHandler = true;
//        } catch (InterruptedException | ServiceBusException e) {
//            log.error("Error registering event handler. " + e.getMessage());
//        }
//        return registeredEventHandler;
//	}
//
//}
