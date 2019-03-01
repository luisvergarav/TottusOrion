package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.stereotype.Component;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;

@Component
public class HierarchyUpdateProductCommandBus implements CommandBus<HierarchyUpdateProductCommandImpl> {

	
	HierarchyUpdateProductHandler handler;

	public HierarchyUpdateProductCommandBus(HierarchyUpdateProductHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(HierarchyUpdateProductCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}