package rtl.tot.corp.ecom.pctm.cachemanager.domain.events;

public enum EventType {
    PRODUCT_DELETED("productDeleted"),
    PRODUCT_CREATED("productCreated"),
    PRODUCT_UPDATED("productUpdated");
    private final String name;

    EventType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

