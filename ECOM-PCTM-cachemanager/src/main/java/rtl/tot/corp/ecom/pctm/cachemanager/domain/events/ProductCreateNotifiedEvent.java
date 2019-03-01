package rtl.tot.corp.ecom.pctm.cachemanager.domain.events;


import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import rtl.tot.corp.ecom.pctm.cachemanager.domain.EanSecundary;
import rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.input.asb.EventDomain;

@JsonIgnoreProperties({"mapper", "entityType"})
public class ProductCreateNotifiedEvent implements EventDomain{

			
		private final ObjectMapper mapper = new ObjectMapper();
		 
		
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
		Hierarchy hierarchy = new Hierarchy();
		
		@Override
		@JsonIgnore
		public String getEntityId() {
			// TODO Auto-generated method stub
			return sku;
		}

		@Override
		@JsonIgnore
		public String getMetadata() {
			String jsonValue;
	        try {
	            jsonValue = mapper.writeValueAsString(this);
	        } catch (JsonProcessingException e) {
	            jsonValue = super.toString();
	        }
	        return jsonValue;
		}

		@Override
		public String getEntityType() {
			return getClass().getName();
		}

		public ObjectMapper getMapper() {
			return mapper;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getLevelId() {
			return levelId;
		}

		public void setLevelId(Long levelId) {
			this.levelId = levelId;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getEan() {
			return ean;
		}

		public void setEan(Long ean) {
			this.ean = ean;
		}

		public String getUnitMeasure() {
			return unitMeasure;
		}

		public void setUnitMeasure(String unitMeasure) {
			this.unitMeasure = unitMeasure;
		}

		public String getSaleUnit() {
			return saleUnit;
		}

		public void setSaleUnit(String saleUnit) {
			this.saleUnit = saleUnit;
		}

		public String getPosDescription() {
			return posDescription;
		}

		public void setPosDescription(String posDescription) {
			this.posDescription = posDescription;
		}

		public String getFlejeDescription() {
			return flejeDescription;
		}

		public void setFlejeDescription(String flejeDescription) {
			this.flejeDescription = flejeDescription;
		}

		public Integer getCodeSupplier() {
			return codeSupplier;
		}

		public void setCodeSupplier(Integer codeSupplier) {
			this.codeSupplier = codeSupplier;
		}

		public String getNameSupplier() {
			return nameSupplier;
		}

		public void setNameSupplier(String nameSupplier) {
			this.nameSupplier = nameSupplier;
		}

		public String getQtyCasePack() {
			return qtyCasePack;
		}

		public void setQtyCasePack(String qtyCasePack) {
			this.qtyCasePack = qtyCasePack;
		}

		public String getNameCasePack() {
			return nameCasePack;
		}

		public void setNameCasePack(String nameCasePack) {
			this.nameCasePack = nameCasePack;
		}

		public String getCodeSUNAT() {
			return codeSUNAT;
		}

		public void setCodeSUNAT(String codeSUNAT) {
			this.codeSUNAT = codeSUNAT;
		}

		public Hierarchy getHierarchy() {
			return hierarchy;
		}

		public void setHierarchy(Hierarchy hierarchy) {
			this.hierarchy = hierarchy;
		}

		@Data
		public static class Hierarchy {
			String skuCode;
			String skuName;
			Long skuCodeLevel;
			String subClass;
			String subClassName;
			Integer subClassLevel;
			@JsonProperty(value="class")
			String clazz;
			String className;
			Integer classLevel;
			
			String subDepartment;
			String subDepartmentName;
			Integer subDepartmentLevel;
			
			String department;
			String departmentName;
			Integer departmentLevel;
			
			String division;
			String divisionName;

			Integer divisionLevel;
		}
		
		


}
