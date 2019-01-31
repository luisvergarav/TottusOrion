package rtl.tot.corp.ecom.pctm.cachemanager.arq.event;

@FunctionalInterface
public interface EventHandler {
    void processEvent(final Event event);
}
