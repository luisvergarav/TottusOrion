package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.stereotype.Component;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CommandBus;

@Component
public class StateUpdateProductCommandBus implements CommandBus<StateUpdateProductCommandImpl> {

	
	StateUpdateProductHandler handler;

	public StateUpdateProductCommandBus(StateUpdateProductHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(StateUpdateProductCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}