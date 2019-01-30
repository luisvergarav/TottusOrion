package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events.ProductCreatedInternalEvent;

@Component
@Slf4j
public class ProductCreatedEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
 
    public void publishAnEvent(ProductCreatedInternalEvent customSpringEvent) {
		log.info("Publishing ProductCreated event", customSpringEvent.toString());
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}