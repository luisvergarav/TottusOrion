package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Command;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;

@Component
public class CreateProductCommandBus implements CommandBus<CreateProductCommandImpl> {

	
	CreateProductHandler handler;

	public CreateProductCommandBus(CreateProductHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(CreateProductCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}