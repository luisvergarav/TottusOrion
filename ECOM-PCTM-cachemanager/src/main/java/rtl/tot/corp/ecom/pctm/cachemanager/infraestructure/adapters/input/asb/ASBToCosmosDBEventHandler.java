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
		    integrationEvent.setBrand(product.getBrand());
		    integrationEvent.setCodeSUNAT(product.getCodeSUNAT());
		    integrationEvent.setCodeSupplier(product.getCodeSupplier());
		    integrationEvent.setDescription(product.getDescription());
		    integrationEvent.setEan(product.getEan());
		    integrationEvent.setFlejeDescription(product.getFlejeDescription());
		    integrationEvent.setLevelId(product.getLevelId());
		    integrationEvent.setModel(product.getModel());
		    integrationEvent.setNameCasePack(product.getNameCasePack());
		    integrationEvent.setNameSupplier(product.getNameSupplier());
		    integrationEvent.setPosDescription(product.getPosDescription());
		    integrationEvent.setProductType(product.getProductType());
		    integrationEvent.setQtyCasePack(product.getQtyCasePack());
		    integrationEvent.setSaleUnit(product.getSaleUnit());
		    integrationEvent.setStatus(product.getStatus());
		    integrationEvent.setUnitMeasure(product.getUnitMeasure());
		    
		    integrationEvent.getHierarchy().setClassLevel(product.getHierarchy().getClassLevel());
		    integrationEvent.getHierarchy().setClassName(product.getHierarchy().getClassName());
		    integrationEvent.getHierarchy().setClazz(product.getHierarchy().getClazz());
		    integrationEvent.getHierarchy().setDepartment(product.getHierarchy().getDepartment());
		    integrationEvent.getHierarchy().setDepartmentLevel(product.getHierarchy().getDepartmentLevel());
		    integrationEvent.getHierarchy().setDepartmentName(product.getHierarchy().getDepartmentName());
		    integrationEvent.getHierarchy().setDivision(product.getHierarchy().getDivision());
		    integrationEvent.getHierarchy().setDivisionLevel(product.getHierarchy().getDivisionLevel());
		    integrationEvent.getHierarchy().setDivisionName(product.getHierarchy().getDivisionName());
		    integrationEvent.getHierarchy().setSkuCode(product.getHierarchy().getSkuCode());
		    integrationEvent.getHierarchy().setSkuCodeLevel(product.getHierarchy().getSkuCodeLevel());
		    integrationEvent.getHierarchy().setSkuName(product.getHierarchy().getSkuName());
		    integrationEvent.getHierarchy().setSubClass(product.getHierarchy().getSubClass());
		    integrationEvent.getHierarchy().setSubClassLevel(product.getHierarchy().getSubClassLevel());
		    integrationEvent.getHierarchy().setSubClassName(product.getHierarchy().getSubClassName());
		    integrationEvent.getHierarchy().setSubDepartment(product.getHierarchy().getSubDepartment());
		    integrationEvent.getHierarchy().setSubDepartmentLevel(product.getHierarchy().getSubDepartmentLevel());
		    integrationEvent.getHierarchy().setSubDepartmentName(product.getHierarchy().getSubDepartmentName());
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
