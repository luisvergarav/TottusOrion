package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

public class ProductAggregate {

	final ProductRootEntity  productRootentity;
	
	public ProductAggregate(Builder builder) {
		this.productRootentity = new ProductRootEntity(builder.productId,
				builder.skuDescription,
				builder.levelId,
				builder.tradeMark,
				builder.model,
				builder.productType,
				builder.state,
				builder.ean,
				builder.saleUnit,
				builder.skuPosDescription,
				builder.skuFlejeDescription,
				builder.providerId,
				builder.provider,
				builder.skuCode,
				builder.skuCodeDescription,
				builder.subClass,
				builder.subClassDescription,
				builder.clazz,
				builder.classDescription,
				builder.subDepartment,
				builder.subDepartmentDescription,
				builder.department,
				builder.departDescription,
				builder.division,
				builder.divisionDesc);
		
	}
	
	public boolean isValid() {
		return true;
	}
	
	public boolean addProduct(ProductService service) {
		return service.addProduct(this);
	}
	
	public static class Builder{
		private String productId;
		private String skuDescription;
		private Long levelId;
		private String tradeMark;
		private String model;
		private String productType;
		private String state;
		private Long ean;
		private String saleUnit;
		private String skuPosDescription;
		private String skuFlejeDescription;
		private Long providerId;
		private String provider;
		private String skuCode;
		private String skuCodeDescription;
		private String subClass;
		private String subClassDescription;
		private String clazz;
		private String classDescription;
		private String subDepartment;
		private String subDepartmentDescription;
		private String department;
		private String departDescription;
		private String division;
		private String divisionDesc;
		
		public ProductAggregate build() {
			
			return new ProductAggregate(this);
		}
		public Builder productId(String productId) {
			this.productId = productId;
			return this;
		}
		public Builder skuDescription(String skuDescription) {
			this.skuDescription = skuDescription;
			return this;
		}
		public Builder levelId(Long levelId) {
			this.levelId = levelId;
			return this;
		}
		public Builder tradeMark(String tradeMark) {
			this.tradeMark = tradeMark;
			return this;
		}
		public Builder model(String model) {
			this.model = model;
			return this;
		}
		public Builder productType(String productType) {
			this.productType = productType;
			return this;
		}
		public Builder state(String state) {
			this.state = state;
			return this;
		}
		public Builder ean(Long ean) {
			this.ean = ean;
			return this;
		}
		public Builder saleUnit(String saleUnit) {
			this.saleUnit = saleUnit;
			return this;
		}
		public Builder skuPosDescription(String skudPosDescription) {
			this.skuPosDescription = skudPosDescription;
			return this;
		}
		public Builder skuFlejeDescription(String skuFlejeDescription) {
			this.skuFlejeDescription = skuFlejeDescription;
			return this;
		}
		public Builder providerId(Long providerId) {
			this.providerId = providerId;
			return this;
		}
		public Builder provider(String provider) {
			this.provider = provider;
			return this;
		}
		public Builder skuCode(String skuCode) {
			this.skuCode = skuCode;
			return this;
		}
		public Builder skuCodeDescription(String skuCodeDescription) {
			this.skuCodeDescription = skuCodeDescription;
			return this;
		}
		public Builder subClass(String subClass) {
			this.subClass = subClass;
			return this;
		}
		public Builder subClassDescription(String subClassDescription) {
			this.subClassDescription = subClassDescription;
			return this;
		}
		public Builder clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}
		public Builder classDescription(String classDescription) {
			this.classDescription = classDescription;
			return this;
		}
		public Builder subDepartment(String subDepartment) {
			this.subDepartment = subDepartment;
			return this;
		}
		public Builder subDepartmentDescription(String subDepartmentDescription) {
			this.subDepartmentDescription = subDepartmentDescription;
			return this;
		}
		public Builder department(String department) {
			this.department = department;
			return this;
		}
		public Builder departDescription(String departDescription) {
			this.departDescription = departDescription;
			return this;
		}
		public Builder division(String division) {
			this.division = division;
			return this;
		}
		public Builder divisionDesc(String divisionDesc) {
			this.divisionDesc = divisionDesc;
			return this;
		}
		
		
		
	}
}
