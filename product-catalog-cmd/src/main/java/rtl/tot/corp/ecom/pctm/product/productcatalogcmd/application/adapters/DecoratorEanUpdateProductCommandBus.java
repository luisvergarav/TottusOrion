package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductEanUpdatedIntegrationEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventPublisherService;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventType;
@Component
@Slf4j
public class DecoratorEanUpdateProductCommandBus implements CommandBus<EanUpdateProductCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	EanUpdateProductCommandBus bus;
	
    public DecoratorEanUpdateProductCommandBus(EanUpdateProductCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(EanUpdateProductCommandImpl command) throws Exception {

	        ProductEanUpdatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new ProductEanUpdatedIntegrationEvent();
    	        
    	      
    	        integrationEvent.setSku(command.getSku());
    	        integrationEvent.setEan(command.getEan());
    	     
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending ProductEanUpdatedEvent integration Event " , command.getSku());
    	       	 
    	        	publisher.publish(EventType.PRODUCT_EANUPDATED, integrationEvent);
    				return true;    	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending ProductEanUpdatedEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}