package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider;

import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.Event;

@FunctionalInterface
public interface EventPublisher {
    boolean publish(Event event);
}
