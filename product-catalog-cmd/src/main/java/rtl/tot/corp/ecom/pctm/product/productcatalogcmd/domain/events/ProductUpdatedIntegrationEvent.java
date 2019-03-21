package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventDomain;
@Data
@JsonIgnoreProperties({"mapper", "entityType"})
public class ProductUpdatedIntegrationEvent  implements EventDomain {
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
	Float qtyCasePack;
	@NotNull
	String nameCasePack;
	@NotNull
	String codeSUNAT;
	@NotNull
	List<EanSecundary> eanSecundary = new ArrayList<EanSecundary>();
	@NotNull
	Hierarchy hierarchy = new Hierarchy();
	@NotNull
	LogisticAttributes logisticAttributes = new LogisticAttributes();
	@NotNull
	Conservation conservation = new Conservation();
	@NotNull
	Assortment assortment = new Assortment();
	@NotNull
	List<Attribute> attribute = new ArrayList<Attribute>();
	@NotNull
	List<Multivalue> multivalue = new ArrayList<Multivalue>();

	private final ObjectMapper mapper = new ObjectMapper();
	 
		
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

	


	
	
}
