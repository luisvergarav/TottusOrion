package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ProductAggregate {

	final ProductRootEntity  productRootentity;
	
	public ProductAggregate(Builder builder) {
		this.productRootentity = new ProductRootEntity(
				builder.sku,
				builder.description,
				builder.levelId,
				builder.brand,
				builder.model,
				builder.productType,
				builder.status,
				builder.ean,
				builder.unitMeasure,
				builder.saleUnit,
				builder.posDescription,
				builder.flejeDescription,
				builder.codeSupplier,
				builder.nameSupplier,
				builder.qtyCasePack,
				builder.nameCasePack,
				builder.codeSUNAT,
				builder.eanSecundary,
				builder.hierarchy,
				builder.logisticAttributes,
				builder.conservation,
				builder.assortment,
				builder.attribute
				
				
				);
		
	}
	
	public boolean isValid() {
		return true;
	}
	
	public boolean addProduct(ProductService service) {
		return service.addProduct(this);
	}
	
	
	public boolean updateProduct(ProductService service) {
		return service.addProduct(this);
	}
	
	public static class Builder{
		
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
		
		String qtyCasePack;
		
		String nameCasePack;
		
		String codeSUNAT;
		
		List <EanSecundary> eanSecundary = new ArrayList <EanSecundary>();
		
		Hierarchy hierarchy = new Hierarchy();
		
		LogisticAttributes logisticAttributes = new LogisticAttributes();
		
		Conservation conservation = new Conservation();
		
		Assortment assortment = new Assortment();
		
		List <Attribute> attribute = new ArrayList<Attribute>();
		
		public ProductAggregate build() {
			
			return new ProductAggregate(this);
		}
		public Builder sku(String sku) {
			this.sku = sku;
			return this;
		}

		
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public Builder setLevelId(Long levelId) {
			this.levelId = levelId;
			return this;
		}
		
		public Builder setBrand(String brand) {
			this.brand = brand;
			return this;
		}
		
		public Builder setModel(String model) {
			this.model = model;
			return this;
		}
		
		public Builder setProductType(String productType) {
			this.productType = productType;
			return this;
		}
		
		public Builder setStatus(String status) {
			this.status = status;
			return this;
		}
		
		public Builder setEan(Long ean) {
			this.ean = ean;
			return this;
		}
		
		public Builder setUnitMeasure(String unitMeasure) {
			this.unitMeasure = unitMeasure;
			return this;
		}
		
		public Builder setSaleUnit(String saleUnit) {
			this.saleUnit = saleUnit;
			return this;
		}
		
		public Builder setPosDescription(String posDescription) {
			this.posDescription = posDescription;
			return this;
		}
		
		public Builder setFlejeDescription(String flejeDescription) {
			this.flejeDescription = flejeDescription;
			return this;
		}
		
		public Builder setCodeSupplier(Integer codeSupplier) {
			this.codeSupplier = codeSupplier;
			return this;
		}
		
		public Builder setNameSupplier(String nameSupplier) {
			this.nameSupplier = nameSupplier;
			return this;
		}
		
		public Builder setQtyCasePack(String qtyCasePack) {
			this.qtyCasePack = qtyCasePack;
			return this;
		}
		
		public Builder setNameCasePack(String nameCasePack) {
			this.nameCasePack = nameCasePack;
			return this;
		}
		
		public Builder setCodeSUNAT(String codeSUNAT) {
			this.codeSUNAT = codeSUNAT;
			return this;
		}
		
		public Builder setEanSecundary(List<EanSecundary> eanSecundary) {
			this.eanSecundary = eanSecundary;
			return this;
		}
		
		public Builder setHierarchy(Hierarchy hierarchy) {
			this.hierarchy = hierarchy;
			return this;
		}
		
		public Builder setLogisticAttributes(LogisticAttributes logisticAttributes) {
			this.logisticAttributes = logisticAttributes;
			return this;
		}
		
		public Builder setConservation(Conservation conservation) {
			this.conservation = conservation;
			return this;
		}
		
		public Builder setAssortment(Assortment assortment) {
			this.assortment = assortment;
			return this;
		}
		
		public Builder setAttribute(List<Attribute> attribute) {
			this.attribute = attribute;
			return this;
		}



		
	}
}
