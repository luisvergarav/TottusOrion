package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductEanUpdatedIntegrationEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductHierarchyUpdatedIntegrationEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventPublisherService;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventType;
@Component
@Slf4j
public class DecoratorHierarchyUpdateProductCommandBus implements CommandBus<HierarchyUpdateProductCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	HierarchyUpdateProductCommandBus bus;
	
    public DecoratorHierarchyUpdateProductCommandBus(HierarchyUpdateProductCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(HierarchyUpdateProductCommandImpl command) throws Exception {

	        ProductHierarchyUpdatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new ProductHierarchyUpdatedIntegrationEvent();
    	        
    	      
    	        integrationEvent.setSkuCode(command.getSkuCode());
    	        integrationEvent.setClassLevel(command.getClassLevel());
    	        integrationEvent.setClassName(command.getClassName());
    	        integrationEvent.setClazz(command.getClazz());
    	        integrationEvent.setDepartment(command.getDepartment());
    	        integrationEvent.setDepartmentLevel(command.getDepartmentLevel());
    	        integrationEvent.setDepartmentName(command.getDepartmentName());
    	        integrationEvent.setDivision(command.getDivision());
    	        integrationEvent.setDivisionLevel(command.getDivisionLevel());
    	        integrationEvent.setDivisionName(command.getDivisionName());
    	        integrationEvent.setSkuCodeLevel(command.getSkuCodeLevel());
    	        integrationEvent.setSkuName(command.getSkuName());
    	        integrationEvent.setSubClass(command.getSubClass());
    	        integrationEvent.setSubClassLevel(command.getSubClassLevel());
    	        integrationEvent.setSubClassName(command.getSubClassName());
    	        integrationEvent.setSubDepartment(command.getSubDepartment());
    	        integrationEvent.setSubDepartmentLevel(command.getSubDepartmentLevel());
    	        integrationEvent.setSubDepartmentName(command.getSubDepartmentName());
    	        
    	     
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending ProductHierarchyUpdatedEvent integration Event " , command.getSkuCode());
    	       	 
    	        	publisher.publish(EventType.PRODUCT_HIERARCHYUPDATED, integrationEvent);
    				return true;    	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending ProductHierarchyUpdatedEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}