package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import lombok.Data;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CreateProductCommand;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.ProductHierarchyUpdate;

@Data
public class HierarchyUpdateProductCommandImpl implements CreateProductCommand<ProductHierarchyUpdate> {
	
	
	String skuCode;
	String skuName;
	Long skuCodeLevel;
	String subClass;
	String subClassName;
	Integer subClassLevel;
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
	

	public HierarchyUpdateProductCommandImpl(ProductHierarchyUpdate productHierarchyUpdate) {
		super();
		this.skuCode = productHierarchyUpdate.getSkuCode();
		this.skuName = productHierarchyUpdate.getSkuName();
		this.skuCodeLevel = productHierarchyUpdate.getSkuCodeLevel();
		this.subClass = productHierarchyUpdate.getSubClass();
		this.subClassName = productHierarchyUpdate.getSubClassName();
		this.subClassLevel = productHierarchyUpdate.getSubClassLevel();
		this.clazz = productHierarchyUpdate.getClazz();
		this.className = productHierarchyUpdate.getClassName();
		this.classLevel = productHierarchyUpdate.getClassLevel();
		this.subDepartment = productHierarchyUpdate.getSubDepartment();
		this.subDepartmentName = productHierarchyUpdate.getSubDepartmentName();
		this.subDepartmentLevel = productHierarchyUpdate.getSubDepartmentLevel();
		this.department = productHierarchyUpdate.getDepartment();
		this.departmentName = productHierarchyUpdate.getDepartmentName();
		this.departmentLevel = productHierarchyUpdate.getDepartmentLevel();
		this.division = productHierarchyUpdate.getDivision();
		this.divisionName = productHierarchyUpdate.getDivisionName();
		this.divisionLevel = productHierarchyUpdate.getDivisionLevel();
		}

	
	

}