package rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.input.asb.queue;
import com.microsoft.azure.servicebus.*;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ServiceBusSampleApplication  {

 
    @Autowired
    private SubscriptionClient subscriptionClient;

  

    public ServiceBusSampleApplication(
    		final SubscriptionClient subscriptionClient) throws ServiceBusException, InterruptedException{
 
        receiveSubscriptionMessage();
    }

  

    private void receiveSubscriptionMessage() throws ServiceBusException, InterruptedException {
        subscriptionClient.registerMessageHandler(new MessageHandler(), new MessageHandlerOptions());

        TimeUnit.SECONDS.sleep(5);
        subscriptionClient.close();
    }

    static class MessageHandler implements IMessageHandler {
        public CompletableFuture<Void> onMessageAsync(IMessage message) {
            final String messageString = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("Received message: " + messageString);
            return CompletableFuture.completedFuture(null);
        }

        public void notifyException(Throwable exception, ExceptionPhase phase) {
            System.out.println(phase + " encountered exception:" + exception.getMessage());
        }
    }
}