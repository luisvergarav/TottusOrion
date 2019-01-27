package rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.input.asb;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.EventSubscriber;

@Service
public class EventSubscriberService {

    public EventSubscriberService(final EventSubscriber eventSubscriber,
                                  final ASBToCosmosDBEventHandler asbToCosmosDBEventHandler) {
        eventSubscriber.registerEventHandler(asbToCosmosDBEventHandler);
    }

}
