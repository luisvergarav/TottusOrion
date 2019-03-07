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
    	        
    	        integrationEvent.setSku(command.getSku());
    	        integrationEvent.getHierarchy().setSkuCode(command.getHierarchy().getSkuCode());
    	        integrationEvent.getHierarchy().setClassLevel(command.getHierarchy().getClassLevel());
    	        integrationEvent.getHierarchy().setClassName(command.getHierarchy().getClassName());
    	        integrationEvent.getHierarchy().setClazz(command.getHierarchy().getClazz());
    	        integrationEvent.getHierarchy().setDepartment(command.getHierarchy().getDepartment());
    	        integrationEvent.getHierarchy().setDepartmentLevel(command.getHierarchy().getDepartmentLevel());
    	        integrationEvent.getHierarchy().setDepartmentName(command.getHierarchy().getDepartmentName());
    	        integrationEvent.getHierarchy().setDivision(command.getHierarchy().getDivision());
    	        integrationEvent.getHierarchy().setDivisionLevel(command.getHierarchy().getDivisionLevel());
    	        integrationEvent.getHierarchy().setDivisionName(command.getHierarchy().getDivisionName());
    	        integrationEvent.getHierarchy().setSkuCodeLevel(command.getHierarchy().getSkuCodeLevel());
    	        integrationEvent.getHierarchy().setSkuName(command.getHierarchy().getSkuName());
    	        integrationEvent.getHierarchy().setSubClass(command.getHierarchy().getSubClass());
    	        integrationEvent.getHierarchy().setSubClassLevel(command.getHierarchy().getSubClassLevel());
    	        integrationEvent.getHierarchy().setSubClassName(command.getHierarchy().getSubClassName());
    	        integrationEvent.getHierarchy().setSubDepartment(command.getHierarchy().getSubDepartment());
    	        integrationEvent.getHierarchy().setSubDepartmentLevel(command.getHierarchy().getSubDepartmentLevel());
    	        integrationEvent.getHierarchy().setSubDepartmentName(command.getHierarchy().getSubDepartmentName());
    	        
    	     
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending ProductHierarchyUpdatedEvent integration Event " , command.getSku());
    	       	 
    	        	return publisher.publish(EventType.PRODUCT_HIERARCHYUPDATED, integrationEvent);
    				    	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending ProductHierarchyUpdatedEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}