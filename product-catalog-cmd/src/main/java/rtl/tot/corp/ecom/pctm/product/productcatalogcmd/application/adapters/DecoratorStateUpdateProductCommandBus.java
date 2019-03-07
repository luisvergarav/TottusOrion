package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductStateUpdatedIntegrationEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventPublisherService;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventType;@Component
@Slf4j
public class DecoratorStateUpdateProductCommandBus implements CommandBus<StateUpdateProductCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	StateUpdateProductCommandBus bus;
	
    public DecoratorStateUpdateProductCommandBus(StateUpdateProductCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(StateUpdateProductCommandImpl command) throws Exception {

	        ProductStateUpdatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new ProductStateUpdatedIntegrationEvent();
    	        
    	      
    	        integrationEvent.setSku(command.getSku());
    	        integrationEvent.setStatus(command.getStatus());
    	     
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending ProductStateUpdatedEvent integration Event " , command.getSku());
    	       	 
    	        	return publisher.publish(EventType.PRODUCT_STATEUPDATED, integrationEvent);
    				   	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending ProductStateUpdatedEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}