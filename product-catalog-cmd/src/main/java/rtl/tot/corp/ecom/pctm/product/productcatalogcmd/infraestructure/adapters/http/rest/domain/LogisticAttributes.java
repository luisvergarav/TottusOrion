package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain;

import lombok.Data;

@Data
public class LogisticAttributes {
String unitWeight;
Double valueWeight;
String unitMeasure;
Double length;
Float width;
Float high;
String unitMeasureCasePack;
Float lengthCasePack;
Float widthCasePack;
Float highCasePack;
Long palletHi;
Float palletTier;
}
