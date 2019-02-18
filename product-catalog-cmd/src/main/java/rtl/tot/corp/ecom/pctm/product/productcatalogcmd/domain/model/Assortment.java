package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

import lombok.Data;

@Data
public class Assortment {
Integer store;

public Assortment(Integer store) {
	super();
	this.store = store;
}
public Assortment() {
}
}
