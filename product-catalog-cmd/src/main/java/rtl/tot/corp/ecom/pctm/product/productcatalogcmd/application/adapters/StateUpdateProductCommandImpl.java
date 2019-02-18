package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import lombok.Data;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CreateProductCommand;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.StateUpdateProduct;

@Data
public class StateUpdateProductCommandImpl implements CreateProductCommand<StateUpdateProduct> {
	
	@Id
	@NotNull
	String sku;
	@NotNull
	String status;
	

	public StateUpdateProductCommandImpl(StateUpdateProduct stateUpdateProduct) {
		super();
		this.sku = stateUpdateProduct.getSku();
		this.status = stateUpdateProduct.getStatus();
		}

	
	

}