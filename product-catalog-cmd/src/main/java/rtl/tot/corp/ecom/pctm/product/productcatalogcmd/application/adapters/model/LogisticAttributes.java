package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model;

import lombok.Data;

@Data
public class LogisticAttributes {
String unitWeight;
Double valueWeight;
String unitMeasure;
Double length;
Long width;
Double high;
String unitMeasureCasePack;
Double lengthCasePack;
Long widthCasePack;
Double highCasePack;
Long palletHi;
Integer palletTier;
}
