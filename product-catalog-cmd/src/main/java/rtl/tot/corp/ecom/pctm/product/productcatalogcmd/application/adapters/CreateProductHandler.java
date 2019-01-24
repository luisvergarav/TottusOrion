package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Handler;

@Component
public class CreateProductHandler implements Handler<CreateProductCommandImpl>{

	@Autowired
	ProductServiceApplicationImpl service;
	
	public CreateProductHandler(ProductServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(CreateProductCommandImpl cmd) throws Exception {
		return service.addProduct((CreateProductCommandImpl) cmd);
		
	}

}
