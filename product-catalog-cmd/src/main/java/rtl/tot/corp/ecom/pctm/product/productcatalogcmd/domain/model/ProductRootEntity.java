package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductRootEntity {

	
	public ProductRootEntity(String sku, String description, Long levelId, String brand, String model,
			String productType, String status, Long ean, String unitMeasure, String saleUnit, String posDescription,
			String flejeDescription, Integer codeSupplier, String nameSupplier, Float qtyCasePack, String nameCasePack,
			String codeSUNAT, List<EanSecundary> eanSecundary, Hierarchy hierarchy, LogisticAttributes logisticAttributes,
			Conservation conservation, Assortment assortment, List<Attribute> attribute) {
		super();
		this.sku = sku;
		this.description = description;
		this.levelId = levelId;
		this.brand = brand;
		this.model = model;
		this.productType = productType;
		this.status = status;
		this.ean = ean;
		this.unitMeasure = unitMeasure;
		this.saleUnit = saleUnit;
		this.posDescription = posDescription;
		this.flejeDescription = flejeDescription;
		this.codeSupplier = codeSupplier;
		this.nameSupplier = nameSupplier;
		this.qtyCasePack = qtyCasePack;
		this.nameCasePack = nameCasePack;
		this.codeSUNAT = codeSUNAT;
		this.eanSecundary = eanSecundary;
		this.hierarchy = hierarchy;
		this.logisticAttributes = logisticAttributes;
		this.conservation = conservation;
		this.assortment = assortment;
		this.attribute = attribute;
	}

	String sku;
	
	String description;
	
	Long levelId;
	
	String brand;
	
	String model;
	
	String productType;
	
	String status;
	
	Long ean;
	
	String unitMeasure;
	
	String saleUnit;
	
	String posDescription;
	
	String flejeDescription;
	
	Integer codeSupplier;
	
	String nameSupplier;
	
	Float qtyCasePack;
	
	String nameCasePack;
	
	String codeSUNAT;
	
	List<EanSecundary> eanSecundary;
	
	Hierarchy hierarchy;
	
	LogisticAttributes logisticAttributes;
	
	Conservation conservation;
	
	Assortment assortment;
	
	List<Attribute> attribute;
	
	
	
	
}
