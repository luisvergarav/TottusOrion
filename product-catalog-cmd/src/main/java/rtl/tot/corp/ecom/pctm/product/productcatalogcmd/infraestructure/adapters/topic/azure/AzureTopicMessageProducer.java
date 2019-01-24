package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.topic.azure;

import com.microsoft.azure.servicebus.*;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.ports.IncommingMessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
//
//@Service
//@Slf4j
//public class AzureTopicMessageProducer implements IncommingMessageListener {
//
//   
//    private TopicClient topicClient;
//    
//   
//    
//   
//
//    private void sendTopicMessage() throws ServiceBusException, InterruptedException {
//        final String messageBody = "topic message";
//        System.out.println("Sending message: " + messageBody);
//        final Message message = new Message(messageBody.getBytes(StandardCharsets.UTF_8));
//        topicClient.send(message);
//        topicClient.close();
//    }
//
//    
//    
//	@Override
//	public void notify(String requestJMSMessage, Map<String, String> jmsHeaders) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//}