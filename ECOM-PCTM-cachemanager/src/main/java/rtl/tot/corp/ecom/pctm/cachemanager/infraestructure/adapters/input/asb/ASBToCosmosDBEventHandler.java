package rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.input.asb;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.eventgrid.EventGridClient;


import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.Event;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.EventHandler;
import rtl.tot.corp.ecom.pctm.cachemanager.domain.Product;
import rtl.tot.corp.ecom.pctm.cachemanager.domain.ProductsRepository;
import rtl.tot.corp.ecom.pctm.cachemanager.domain.events.EventType;
import rtl.tot.corp.ecom.pctm.cachemanager.domain.events.ProductCreateNotifiedEvent;
import rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.output.asb.EventPublisherService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ASBToCosmosDBEventHandler implements EventHandler {

	@Autowired
	EventPublisherService publisher;
	private final ProductsRepository productRepository;
	//private final RestTemplate restTemplate;
	//private final String productsApiUrl;

	public ASBToCosmosDBEventHandler(//final RestTemplate restTemplate, 
			final ProductsRepository productRepository
			//,@Value("${api.products.endpoint}") final String productsApiUrl
			) {
		//this.productsApiUrl = productsApiUrl;
		this.productRepository = productRepository;
		//this.restTemplate = restTemplate;
	}

	@Override
	public void processEvent(Event event) {


      ObjectMapper mapper = new ObjectMapper();

		Product product;
		try {
			product = mapper.readValue(event.getMetadata(), Product.class);
			log.info("Persisting product " + product);
			productRepository.save(product);
			ProductCreateNotifiedEvent integrationEvent = new ProductCreateNotifiedEvent();
		        
		    integrationEvent.setSku(event.getEntityId());
		        
		    publisher.publish(EventType.PRODUCT_CREATED, integrationEvent);
			log.info("Published " + event.getMetadata());
			
		    
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		// Always evict cache first
//		try {
//			// This call needs to be jailed because the CosmoDB throws an exception
//			// when the target resource doesn't exist.
//			// productsRepository.deleteById(event.getEntityId());
//		} catch (final Exception ex) {
//			log.warn("Resource to be deleted does not exist: " + ex.getMessage());
//		}
//
//		if (!event.getEventType().equals(EventType.PRODUCT_DELETED.toString())) {
//			final String url = productsApiUrl + "/" + event.getEntityId();
//
//			// When an event arrives, ask the Core API for full domain information
//			// And for demonstration purposes, lets assume that the event payload
//			// doesn't have all the information we actually need.
//			// final Product product = restTemplate.getForObject(url, Product.class);
//			// if (product != null ) {
//
//			ObjectMapper mapper = new ObjectMapper();
//
//			Product product;
//			try {
//				product = mapper.readValue(event.getMetadata(), Product.class);
//				log.info("Persisting product " + product);
//				productRepository.save(product);
//
//			} catch (JsonParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
	}

}
