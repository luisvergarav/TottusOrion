package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Assortment {

List<Integer> store = new ArrayList<Integer>();

public Assortment(List<Integer> store) {
	super();
	this.store = store;
}
public Assortment() {
}}
