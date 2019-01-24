package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.input.internal;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.microsoft.azure.management.eventhub.EntityStatus;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.eda.integration.EventPublisherService;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.eda.integration.EventType;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.eda.integration.ProductCreatedIntegrationEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.eda.internal.Event;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductCreatedInternalEvent;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.tools.Convert;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.tools.JsonConvert;

@Component
@Slf4j
public class ProductCreatedEventListener implements ApplicationListener<ProductCreatedInternalEvent> {
    
	//@Autowired
	//private QueueClient queueClient;
	
	@Autowired
	EventPublisherService publisher;
	
	@Override
    public void onApplicationEvent(ProductCreatedInternalEvent event) {
        
	Message message = null;
		try{
			
	        log.info("Received ProductCreated event - Sending integration Event " , event.getSku());
	       
	        
	        ProductCreatedIntegrationEvent integrationEvent = new ProductCreatedIntegrationEvent();
	        
	        integrationEvent.setSku(event.getSku());
	        integrationEvent.setClazz(event.getClazz());
	        integrationEvent.setClassDescription(event.getClassDescription());
	        integrationEvent.setDepartment(event.getDepartment());
	        integrationEvent.setDepartmentDescription(event.getDepartmentDescription());
	        integrationEvent.setDivision(event.getDivision());
	        integrationEvent.setDivisionDescription(event.getDivisionDescription());
	        integrationEvent.setEan(event.getEan());
	        integrationEvent.setLevelID(event.getLevelID());
	        integrationEvent.setModel(event.getModel());
	        integrationEvent.setProductType(event.getProductType());
	        integrationEvent.setProveedorID(event.getProveedorID());
	        integrationEvent.setProvider(event.getProvider());
	        integrationEvent.setSaleUnit(event.getSaleUnit());
	        integrationEvent.setSku(event.getSku());
	        integrationEvent.setSkuCode(event.getSkuCode());
	        integrationEvent.setSkuCodeDescription(event.getSkuCodeDescription());
	        integrationEvent.setSkuDescription(event.getSkuDescription());
	        integrationEvent.setSkuFlejeDescription(event.getSkuFlejeDescription());
	        integrationEvent.setSkuPosDescription(event.getSkuPosDescription());
	        integrationEvent.setState(event.getState());
	        integrationEvent.setSubClass(event.getSubClass());
	        integrationEvent.setSubClassDescription(event.getSubClassDescription());
	        integrationEvent.setSubDepartment(event.getSubDepartment());
	        integrationEvent.setSubDepartmentDescription(event.getSubDepartmentDescription());
	        integrationEvent.setTradeMark(event.getTradeMark());
	        
	        publisher.publish(EventType.PRODUCT_CREATED, integrationEvent);
		} catch (Exception e) {
			log.error("Erro Sending ProductCreateEvent integration Event " +  message, e.getLocalizedMessage());
		}
    
    }
}