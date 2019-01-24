package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.queue.azure;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.ports.IncommingMessageListener;
import lombok.extern.slf4j.Slf4j;

import com.microsoft.azure.servicebus.ExceptionPhase;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.IMessageHandler;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.MessageHandlerOptions;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@DependsOn("queueClient")
@Service
@Slf4j
public class AzureBusIncommingMessageListener implements IncommingMessageListener{

	private QueueClient queueClient;
	
	public AzureBusIncommingMessageListener(QueueClient queueClient){
		try {
			this.queueClient = queueClient;
			//sendQueueMessage();
			receiveQueueMessage();
			
		} catch (ServiceBusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// NOTE: Please be noted that below are the minimum code for demonstrating the usage of autowired clients.
    // For complete documentation of Service Bus, reference https://azure.microsoft.com/en-us/services/service-bus/
//    private void sendQueueMessage() throws ServiceBusException, InterruptedException {
//        final String messageBody = "queue message";
//        System.out.println("Sending message: " + messageBody);
//        final Message message = new Message(messageBody.getBytes(StandardCharsets.UTF_8));
//        
//        queueClient.send(message);
//    }
    
    private void receiveQueueMessage() throws ServiceBusException, InterruptedException {
        queueClient.registerMessageHandler(new MessageHandler(), new MessageHandlerOptions());

        //TimeUnit.SECONDS.sleep(5);
        queueClient.close();
    }

    
    static class MessageHandler implements IMessageHandler {
        public CompletableFuture<Void> onMessageAsync(IMessage message) {
            final String messageString = new String(message.getBody(), StandardCharsets.UTF_8);
            
            
            log.info("Recv msg...! " + messageString );
            
            return CompletableFuture.completedFuture(null);
        }

        public void notifyException(Throwable exception, ExceptionPhase phase) {
            System.out.println(phase + " encountered exception:" + exception.getMessage());
        }
    }
    
    
	@Override
	public void notify(String requestJMSMessage, Map<String, String> jmsHeaders) throws Exception {
	}


}