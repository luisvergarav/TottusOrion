package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.stereotype.Component;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;

@Component
public class EanUpdateProductCommandBus implements CommandBus<EanUpdateProductCommandImpl> {

	
	EanUpdateProductHandler handler;

	public EanUpdateProductCommandBus(EanUpdateProductHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(EanUpdateProductCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}