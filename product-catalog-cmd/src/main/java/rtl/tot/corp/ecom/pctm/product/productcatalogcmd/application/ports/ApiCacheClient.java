package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.ports;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.eda.internal.Event;

public interface ApiCacheClient {
	public boolean save(Event event);
}
