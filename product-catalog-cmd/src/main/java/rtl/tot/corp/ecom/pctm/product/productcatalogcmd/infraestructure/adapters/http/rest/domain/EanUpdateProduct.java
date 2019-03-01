package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * order object for order update API
 * 
 * @author: jameswang
 * @version: 1.0, Feb 2, 2018
 */
@Data
public class EanUpdateProduct implements Serializable {

	
	private static final long serialVersionUID = -572762871270068065L;

	@NotNull
	String sku;
	@NotNull
	String ean;

}
