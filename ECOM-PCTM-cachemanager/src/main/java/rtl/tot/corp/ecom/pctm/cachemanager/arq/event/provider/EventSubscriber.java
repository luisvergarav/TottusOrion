package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider;

import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.EventHandler;

@FunctionalInterface
public interface EventSubscriber {
    boolean registerEventHandler(EventHandler eventHandler);
}
