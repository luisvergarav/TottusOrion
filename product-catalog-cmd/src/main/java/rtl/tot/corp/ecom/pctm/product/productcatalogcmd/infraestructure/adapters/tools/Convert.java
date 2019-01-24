package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.tools;

public interface Convert<T> {

	
	String convert(T clazz) throws Exception;
}