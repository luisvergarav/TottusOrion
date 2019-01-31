package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.events;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Hierarchy {
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
}
