package rtl.tot.corp.ecom.pctm.cachemanager.domain;

import java.io.Serializable;
import java.util.List;

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
	String description;
	@NotNull
	Long levelId;
	@NotNull
	String brand;
	@NotNull
	String model;
	@NotNull
	String productType;
	@NotNull
	String status;
	@NotNull
	Long ean;
	@NotNull
	String unitMeasure;
	@NotNull
	String saleUnit;
	@NotNull
	String posDescription;
	@NotNull
	String flejeDescription;
	@NotNull
	Integer codeSupplier;
	@NotNull
	String nameSupplier;
	@NotNull
	String qtyCasePack;
	@NotNull
	String nameCasePack;
	@NotNull
	String codeSUNAT;
	@NotNull
	List<EanSecundary> eanSecundary;
	@NotNull
	Hierarchy hierarchy;
	@NotNull
	LogisticAttributes logisticAttributes;
	@NotNull
	Conservation conservation;
	@NotNull
	Assortment assortment;
	@NotNull
	List<Attribute> attribute;
}
