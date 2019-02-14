package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Handler;

@Component
public class UpdateProductHandler implements Handler<UpdateProductCommandImpl>{

	@Autowired
	ProductServiceApplicationImpl service;
	
	public UpdateProductHandler(ProductServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(UpdateProductCommandImpl cmd) throws Exception {
		return service.updateProduct((UpdateProductCommandImpl) cmd);
		
	}

}
