package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain;

import lombok.Data;

@Data
public class Conservation {
Integer tvu;
String conservation;
String typeSanitaryRegistration;
String numSanitaryRegistration;
String startDateSanitaryRegistration;
String endDateSanitaryRegistration;
Integer tmr;
}
