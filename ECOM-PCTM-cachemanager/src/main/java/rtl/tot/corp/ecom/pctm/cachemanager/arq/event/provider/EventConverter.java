package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider;

import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.Event;

public interface EventConverter<T> {
    T toMessage(Event event);
    Event fromMessage(T message);
}
