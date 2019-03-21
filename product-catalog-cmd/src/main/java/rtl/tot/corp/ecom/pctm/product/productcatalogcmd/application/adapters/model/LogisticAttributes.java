package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model;

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
