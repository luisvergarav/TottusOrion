package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.azureservicebus;

import com.microsoft.azure.servicebus.IMessageHandler;
import com.microsoft.azure.servicebus.QueueClient;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.Event;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.EventHandler;

import com.microsoft.azure.servicebus.ExceptionPhase;
import com.microsoft.azure.servicebus.IMessage;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Slf4j
public class AzureQueueMessageHandler implements IMessageHandler {
	
	private final QueueClient queueClient;
	private final EventHandler eventHandler;
	
	
	
	public AzureQueueMessageHandler(QueueClient queueClient,EventHandler eventHandler) {
	this.queueClient = queueClient;
	this.eventHandler = eventHandler;
	}

	public CompletableFuture<Void> onMessageAsync(IMessage message) {
		
		 Assert.notNull(message, "message must not be null");

	       

	            AzureEventConverter converter = new AzureEventConverter();
	            final Event event = converter.fromMessage(message);

	            eventHandler.processEvent(event);
	        
	        return CompletableFuture.completedFuture(null);

	        //return queueClient.completeAsync(message.getLockToken());
		

    }

    public void notifyException(Throwable exception, ExceptionPhase phase) {
        System.out.println(phase + " encountered exception:" + exception.getMessage());
    }
}
