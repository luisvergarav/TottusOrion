package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductCreatedInternalEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Command;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.internal.ProductCreatedEventPublisher;

@Component
public class DecoratorCreateProductCommandBus implements CommandBus<CreateProductCommandImpl> {
	
	@Autowired
	ProductCreatedEventPublisher publisher;
	
	CreateProductCommandBus bus;
	
    public DecoratorCreateProductCommandBus(CreateProductCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(CreateProductCommandImpl command) throws Exception {

    	ProductCreatedInternalEvent customSpringEvent = new ProductCreatedInternalEvent(this);
    	customSpringEvent.setSku(command.getSku());
    	customSpringEvent.setClazz(command.getClazz());
    	customSpringEvent.setClassDescription(command.getClassDescription());
    	customSpringEvent.setDepartment(command.getDepartment());
    	customSpringEvent.setDepartmentDescription(command.getDepartmentDescription());
    	customSpringEvent.setDivision(command.getDivision());
    	customSpringEvent.setDivisionDescription(command.getDivisionDescription());
    	customSpringEvent.setEan(command.getEan());
    	customSpringEvent.setLevelID(command.getLevelID());
    	customSpringEvent.setModel(command.getModel());
    	customSpringEvent.setProductType(command.getProductType());
    	customSpringEvent.setProveedorID(command.getProveedorID());
    	customSpringEvent.setProvider(command.getProvider());
    	customSpringEvent.setSaleUnit(command.getSaleUnit());
    	customSpringEvent.setSku(command.getSku());
    	customSpringEvent.setSkuCode(command.getSkuCode());
    	customSpringEvent.setSkuCodeDescription(command.getSkuCodeDescription());
    	customSpringEvent.setSkuDescription(command.getSkuDescription());
    	customSpringEvent.setSkuFlejeDescription(command.getSkuFlejeDescription());
    	customSpringEvent.setSkuPosDescription(command.getSkuPosDescription());
    	customSpringEvent.setState(command.getState());
    	customSpringEvent.setSubClass(command.getSubClass());
    	customSpringEvent.setSubClassDescription(command.getSubClassDescription());
    	customSpringEvent.setSubDepartment(command.getSubDepartment());
    	customSpringEvent.setSubDepartmentDescription(command.getSubDepartmentDescription());
    	customSpringEvent.setTradeMark(command.getTradeMark());
    	
		if  (this.bus.execute(command)) {
			this.sendEvent(customSpringEvent);
			return true;
		}
		
		//else
		//	this.sendEvent(customSpringEvent); //send event integration 
		return false;
	}


	private void sendEvent(ProductCreatedInternalEvent event) {
			publisher.publishAnEvent(event);
			
		}
	}