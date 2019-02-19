package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Handler;

@Component
public class StateUpdateProductHandler implements Handler<StateUpdateProductCommandImpl>{

	@Autowired
	ProductServiceApplicationImpl service;
	
	public StateUpdateProductHandler(ProductServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(StateUpdateProductCommandImpl cmd) throws Exception {
		return service.stateUpdateProduct((StateUpdateProductCommandImpl) cmd);
		
	}

}
