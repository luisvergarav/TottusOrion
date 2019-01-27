package rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.tools;

public interface Convert<T> {

	
	String convert(T clazz) throws Exception;
}