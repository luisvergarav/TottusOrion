package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events;

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
public class ProductHierarchyUpdatedIntegrationEvent  implements EventDomain {
	@Id
	@NotNull
	String skuCode;
	@NotNull
	String skuName;
	@NotNull
	Long skuCodeLevel;
	@NotNull
	String subClass;
	@NotNull
	String subClassName;
	@NotNull
	Integer subClassLevel;
	@NotNull
	@JsonProperty(value="class")
	String clazz;
	@NotNull
	String className;
	@NotNull
	Integer classLevel;
	
	@NotNull
	String subDepartment;
	@NotNull
	String subDepartmentName;
	@NotNull
	Integer subDepartmentLevel;
	
	@NotNull
	String department;
	@NotNull
	String departmentName;
	@NotNull
	Integer departmentLevel;
	
	@NotNull
	String division;
	@NotNull
	String divisionName;

	@NotNull
	Integer divisionLevel;

	private final ObjectMapper mapper = new ObjectMapper();
	 
		
	@Override
	@JsonIgnore
	public String getEntityId() {
		// TODO Auto-generated method stub
		return skuCode;
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
