package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.Attribute;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.EanSecundary;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.Multivalue;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductCreatedIntegrationEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventPublisherService;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventType;@Component
@Slf4j
public class DecoratorCreateProductCommandBus implements CommandBus<CreateProductCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	CreateProductCommandBus bus;
	
    public DecoratorCreateProductCommandBus(CreateProductCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(CreateProductCommandImpl command) throws Exception {

	        ProductCreatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new ProductCreatedIntegrationEvent();
    	        
    	        integrationEvent.setBrand(command.getBrand());
    	        integrationEvent.setCodeSUNAT(command.getCodeSUNAT());
    	        integrationEvent.setCodeSupplier(command.getCodeSupplier());
    	        integrationEvent.setDescription(command.getDescription());
    	        integrationEvent.setEan(command.getEan());
    	        integrationEvent.setFlejeDescription(command.getFlejeDescription());
    	        integrationEvent.setLevelId(command.getLevelId());
    	        integrationEvent.setModel(command.getModel());
    	        integrationEvent.setNameCasePack(command.getNameCasePack());
    	        integrationEvent.setNameSupplier(command.getNameSupplier());
    	        integrationEvent.setPosDescription(command.getPosDescription());
    	        integrationEvent.setProductType(command.getProductType());
    	        integrationEvent.setQtyCasePack(command.getQtyCasePack());
    	        integrationEvent.setSaleUnit(command.getSaleUnit());
    	        integrationEvent.setSku(command.getSku());
    	        integrationEvent.setStatus(command.getStatus());
    	        integrationEvent.setUnitMeasure(command.getUnitMeasure());
    			if (command.getAssortment() != null) {
    				integrationEvent.getAssortment().setStore(command.getAssortment().getStore());
    			}
    			if (command.getAttribute()  != null ){
	    			for(rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Attribute a: 
	    				command.getAttribute()) {
	    				Attribute attribute = new Attribute();
	    				
	    				attribute.setNameAttribute(a.getNameAttribute());
	    				attribute.setValue(a.getValue());
	    				integrationEvent.getAttribute().add(attribute);
	    			}
    			}
    			
    			if (command.getConservation() != null) {
    				integrationEvent.getConservation().setConservation(command.getConservation().getConservation());
    				integrationEvent.getConservation().setEndDateSanitaryRegistration(command.getConservation().getEndDateSanitaryRegistration());
    				integrationEvent.getConservation().setNumSanitaryRegistration(command.getConservation().getNumSanitaryRegistration());
    				integrationEvent.getConservation().setTmr(command.getConservation().getTmr());
    				integrationEvent.getConservation().setStartDateSanitaryRegistration(command.getConservation().getStartDateSanitaryRegistration());
    				integrationEvent.getConservation().setTvu(command.getConservation().getTvu());
    				integrationEvent.getConservation().setTypeSanitaryRegistration(command.getConservation().getTypeSanitaryRegistration());
    			}
    			
    			if(command.getEanSecundary() != null){
	    			for ( rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.EanSecundary e : 
	    				command.getEanSecundary()) {
	    				EanSecundary eanSecondary = new EanSecundary();
	    				eanSecondary.setEanSecundary(e.getEanSecundary());
	    				integrationEvent.getEanSecundary().add(eanSecondary);
	    			}
    			}
    			if (command.getHierarchy() != null) {
    				integrationEvent.getHierarchy().setClassLevel(command.getHierarchy().getClassLevel());
    				integrationEvent.getHierarchy().setClassName(command.getHierarchy().getClassName());
    				integrationEvent.getHierarchy().setClazz(command.getHierarchy().getClazz());
    				integrationEvent.getHierarchy().setDepartment(command.getHierarchy().getDepartment());
    				integrationEvent.getHierarchy().setDepartmentLevel(command.getHierarchy().getDepartmentLevel());
    				integrationEvent.getHierarchy().setDepartmentName(command.getHierarchy().getDepartmentName());
    				integrationEvent.getHierarchy().setDivision(command.getHierarchy().getDivision());
    				integrationEvent.getHierarchy().setDivisionLevel(command.getHierarchy().getDivisionLevel());
    				integrationEvent.getHierarchy().setDivisionName(command.getHierarchy().getDivisionName());
    				integrationEvent.getHierarchy().setSkuCode(command.getHierarchy().getSkuCode());
    				integrationEvent.getHierarchy().setSkuCodeLevel(command.getHierarchy().getSkuCodeLevel());
    				integrationEvent.getHierarchy().setSkuName(command.getHierarchy().getSkuName());
    				integrationEvent.getHierarchy().setSubClass(command.getHierarchy().getSubClass());
    				integrationEvent.getHierarchy().setSubClassLevel(command.getHierarchy().getSubClassLevel());
    				integrationEvent.getHierarchy().setSubClassName(command.getHierarchy().getSubClassName());
    				integrationEvent.getHierarchy().setSubDepartment(command.getHierarchy().getSubDepartment());
    				integrationEvent.getHierarchy().setSubDepartmentLevel(command.getHierarchy().getSubDepartmentLevel());
    				integrationEvent.getHierarchy().setSubDepartmentName(command.getHierarchy().getSubDepartmentName());
    			}
    			
    			if (command.getLogisticAttributes() != null){
    				integrationEvent.getLogisticAttributes().setHigh(command.getLogisticAttributes().getHigh());
    				integrationEvent.getLogisticAttributes().setHighCasePack(command.getLogisticAttributes().getHighCasePack());
    				integrationEvent.getLogisticAttributes().setLength(command.getLogisticAttributes().getLength());
    				integrationEvent.getLogisticAttributes().setLengthCasePack(command.getLogisticAttributes().getLengthCasePack());
    				integrationEvent.getLogisticAttributes().setPalletHi(command.getLogisticAttributes().getPalletHi());
    				integrationEvent.getLogisticAttributes().setPalletTier(command.getLogisticAttributes().getPalletTier());
    				integrationEvent.getLogisticAttributes().setUnitMeasure(command.getLogisticAttributes().getUnitMeasure());
    				integrationEvent.getLogisticAttributes().setUnitMeasureCasePack(command.getLogisticAttributes().getUnitMeasureCasePack());
    				integrationEvent.getLogisticAttributes().setUnitWeight(command.getLogisticAttributes().getUnitWeight());
    				integrationEvent.getLogisticAttributes().setValueWeight(command.getLogisticAttributes().getValueWeight());
    				integrationEvent.getLogisticAttributes().setWidth(command.getLogisticAttributes().getWidth());
    				integrationEvent.getLogisticAttributes().setWidthCasePack(command.getLogisticAttributes().getWidthCasePack());
    				
    			}
    			
    			if (command.getMultivalue() != null) {
    				for(rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Multivalue mv: command.getMultivalue()) {
    					Multivalue newMultivalue= new Multivalue();
    					newMultivalue.setId(mv.getId());
    					newMultivalue.setLovId(mv.getLovId());
    					newMultivalue.setTitle(mv.getTitle());
    					newMultivalue.setValue(mv.getValue());
    					
    					integrationEvent.getMultivalue().add(newMultivalue);
    				}
    			}
    			
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending ProductCreateEvent integration Event " , command.getSku());
    	       	 
    	        	return publisher.publish(EventType.PRODUCT_CREATED, integrationEvent);
    				   	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending ProductCreateEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}