package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Handler;

@Component
public class EanUpdateProductHandler implements Handler<EanUpdateProductCommandImpl>{

	@Autowired
	ProductServiceApplicationImpl service;
	
	public EanUpdateProductHandler(ProductServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(EanUpdateProductCommandImpl cmd) throws Exception {
		return service.eanUpdateProduct((EanUpdateProductCommandImpl) cmd);
		
	}

}
