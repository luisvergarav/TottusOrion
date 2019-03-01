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
    	        
    	      
    	        integrationEvent.getHierarchy().setSkuCode(command.getSkuCode());
    	        integrationEvent.getHierarchy().setClassLevel(command.getClassLevel());
    	        integrationEvent.getHierarchy().setClassName(command.getClassName());
    	        integrationEvent.getHierarchy().setClazz(command.getClazz());
    	        integrationEvent.getHierarchy().setDepartment(command.getDepartment());
    	        integrationEvent.getHierarchy().setDepartmentLevel(command.getDepartmentLevel());
    	        integrationEvent.getHierarchy().setDepartmentName(command.getDepartmentName());
    	        integrationEvent.getHierarchy().setDivision(command.getDivision());
    	        integrationEvent.getHierarchy().setDivisionLevel(command.getDivisionLevel());
    	        integrationEvent.getHierarchy().setDivisionName(command.getDivisionName());
    	        integrationEvent.getHierarchy().setSkuCodeLevel(command.getSkuCodeLevel());
    	        integrationEvent.getHierarchy().setSkuName(command.getSkuName());
    	        integrationEvent.getHierarchy().setSubClass(command.getSubClass());
    	        integrationEvent.getHierarchy().setSubClassLevel(command.getSubClassLevel());
    	        integrationEvent.getHierarchy().setSubClassName(command.getSubClassName());
    	        integrationEvent.getHierarchy().setSubDepartment(command.getSubDepartment());
    	        integrationEvent.getHierarchy().setSubDepartmentLevel(command.getSubDepartmentLevel());
    	        integrationEvent.getHierarchy().setSubDepartmentName(command.getSubDepartmentName());
    	        
    	     
    	
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