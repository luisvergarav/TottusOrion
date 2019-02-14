package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Command;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;

@Component
public class UpdateProductCommandBus implements CommandBus<UpdateProductCommandImpl> {

	
	UpdateProductHandler handler;

	public UpdateProductCommandBus(UpdateProductHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(UpdateProductCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}