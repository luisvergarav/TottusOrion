package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.azureservicebus;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.microsoft.azure.eventgrid.EventGridClient;
import com.microsoft.azure.eventgrid.TopicCredentials;
import com.microsoft.azure.eventgrid.implementation.EventGridClientImpl;
import com.microsoft.azure.eventgrid.models.EventGridEvent;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.MessageHandlerOptions;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.Event;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.EventHandler;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.EventPublisher;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.EventSubscriber;
//@Slf4j
//public class EventGridClientConfig  implements EventPublisher  {
//
//    @Value("${azure.servicebus.eventgrid.connection-string}")
//    private String endpoint;
//
//    @Value("${azure.servicebus.eventgrid-name}")
//    private String eventGrid;    
//  
//
//    @Value("${azure.servicebus.eventgrid-key}")
//    private String eventGridKey;    
//    
//    EventGridClient client;
//    
//
//    @PostConstruct
//    void postConstruct() throws ServiceBusException, InterruptedException {
//        //Assert.hasText(endpoint, "invalid endpoint");
//        //Assert.hasText(topic, "invalid topic");
//
//    	TopicCredentials topicCredentials = new TopicCredentials(this.eventGridKey);
//        client = new EventGridClientImpl(topicCredentials);
//
//    }
//    
//    
//	@Override
//	public boolean publish(Event event) {
//		 if (event == null) {
//	            return false;
//	        }
//
//	        boolean emitted = false;
//	        try {
//	        	
//	            String topicHostname = new URI(endpoint).getHost();
//	      
//	            
//	            log.info("Publish custom events to the EventGrid", event.getMetadata());
//	            
//	            client.publishEvents(topicHostname, transformEventToMessage(event));
//
//	            emitted = true;
//	        } catch (URISyntaxException e) {
//	            log.error("Error sending event. " + e.getMessage());
//	        }
//	        return emitted;
//	}
//	
//	  protected List<EventGridEvent> transformEventToMessage(final Event event) {
//	        final AzureEventGridConverter converter = new AzureEventGridConverter();
//	        final List<EventGridEvent> message = converter.toMessage(event);
//
//
//	        return message;
//	    }
//}
