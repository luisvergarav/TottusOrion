package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Handler;

@Component
public class HierarchyUpdateProductHandler implements Handler<HierarchyUpdateProductCommandImpl>{

	@Autowired
	ProductServiceApplicationImpl service;
	
	public HierarchyUpdateProductHandler(ProductServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(HierarchyUpdateProductCommandImpl cmd) throws Exception {
		return service.hierarchyUpdateProduct((HierarchyUpdateProductCommandImpl) cmd);
		
	}

}
