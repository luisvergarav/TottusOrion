package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events;

import org.springframework.context.ApplicationEvent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCreatedInternalEvent extends ApplicationEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sku;
	String skuDescription;
	Long levelID;
	String tradeMark;
	String model;
	String productType;
	String state;
	Long ean;
	String saleUnit;
	String skuPosDescription;
	String skuFlejeDescription;
	Integer proveedorID;
	String provider;
	String skuCode;
	String skuCodeDescription;
	String subClass;
	String subClassDescription;
	@JsonProperty(value="class")
	String clazz;
	String classDescription;
	String subDepartment;
	String subDepartmentDescription;
	String department;
	String departmentDescription;
	String division;
	String divisionDescription;
 
    public ProductCreatedInternalEvent(Object source) {
        super(source);
    }

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}

	public Long getLevelID() {
		return levelID;
	}

	public void setLevelID(Long levelID) {
		this.levelID = levelID;
	}

	public String getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getEan() {
		return ean;
	}

	public void setEan(Long ean) {
		this.ean = ean;
	}

	public String getSaleUnit() {
		return saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public String getSkuPosDescription() {
		return skuPosDescription;
	}

	public void setSkuPosDescription(String skuPosDescription) {
		this.skuPosDescription = skuPosDescription;
	}

	public String getSkuFlejeDescription() {
		return skuFlejeDescription;
	}

	public void setSkuFlejeDescription(String skuFlejeDescription) {
		this.skuFlejeDescription = skuFlejeDescription;
	}

	public Integer getProveedorID() {
		return proveedorID;
	}

	public void setProveedorID(Integer proveedorID) {
		this.proveedorID = proveedorID;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuCodeDescription() {
		return skuCodeDescription;
	}

	public void setSkuCodeDescription(String skuCodeDescription) {
		this.skuCodeDescription = skuCodeDescription;
	}

	public String getSubClass() {
		return subClass;
	}

	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}

	public String getSubClassDescription() {
		return subClassDescription;
	}

	public void setSubClassDescription(String subClassDescription) {
		this.subClassDescription = subClassDescription;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String clazzDescription) {
		this.classDescription = clazzDescription;
	}

	public String getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

	public String getSubDepartmentDescription() {
		return subDepartmentDescription;
	}

	public void setSubDepartmentDescription(String subDepartmentDescription) {
		this.subDepartmentDescription = subDepartmentDescription;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDivisionDescription() {
		return divisionDescription;
	}

	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
	}

	
   
}