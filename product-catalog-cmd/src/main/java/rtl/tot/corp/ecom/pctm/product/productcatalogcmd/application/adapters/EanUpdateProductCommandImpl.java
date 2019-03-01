package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import lombok.Data;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CreateProductCommand;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.EanUpdateProduct;

@Data
public class EanUpdateProductCommandImpl implements CreateProductCommand<EanUpdateProduct> {
	
	@Id
	@NotNull
	String sku;
	@NotNull
	String ean;
	

	public EanUpdateProductCommandImpl(EanUpdateProduct eanUpdateProduct) {
		super();
		this.sku = eanUpdateProduct.getSku();
		this.ean = eanUpdateProduct.getEan();
		}

	
	

}