package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

import lombok.Data;

@Data
public class Attribute {
String nameAttribute;
String value;

public Attribute(String nameAttribute, String value) {
	super();
	this.nameAttribute = nameAttribute;
	this.value = value;
}

public Attribute() {
}
}
