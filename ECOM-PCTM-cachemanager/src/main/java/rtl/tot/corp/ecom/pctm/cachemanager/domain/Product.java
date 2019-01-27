package rtl.tot.corp.ecom.pctm.cachemanager.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * order object for order update API
 * 
 * @author: jameswang
 * @version: 1.0, Feb 2, 2018
 */
@Data
public class Product implements Serializable {

	
	private static final long serialVersionUID = -572762871270068065L;

	@Id
	@NotNull
	String sku;
	@NotNull
	String skuDescription;
	@NotNull
	Integer levelID;
	@NotNull
	String tradeMark;
	@NotNull
	String model;
	@NotNull
	String productType;
	@NotNull
	String state;
	@NotNull
	Long ean;
	@NotNull
	String saleUnit;
	@NotNull
	String skuPosDescription;
	@NotNull
	String skuFlejeDescription;
	@NotNull
	Integer proveedorID;
	@NotNull
	String provider;
	@NotNull
	String skuCode;
	@NotNull
	String skuCodeDescription;
	@NotNull
	String subClass;
	@NotNull
	String subClassDescription;
	@NotNull
	@JsonProperty(value="class")
	String clazz;
	@NotNull
	String classDescription;
	@NotNull
	String subDepartment;
	@NotNull
	String subDepartmentDescription;
	@NotNull
	String department;
	@NotNull
	String departmentDescription;
	@NotNull
	String division;
	@NotNull
	String divisionDescription;
}
