package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import javax.validation.constraints.NotNull;

import lombok.Data;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Hierarchy;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CreateProductCommand;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.ProductHierarchyUpdate;

@Data
public class HierarchyUpdateProductCommandImpl implements CreateProductCommand<ProductHierarchyUpdate> {
	

	String sku;
	Hierarchy hierarchy = new Hierarchy();

	

	public HierarchyUpdateProductCommandImpl(ProductHierarchyUpdate productHierarchyUpdate,String sku) {
		super();
		this.sku = sku;
		this.hierarchy.setSkuCode(productHierarchyUpdate.getSkuCode());
		this.hierarchy.setSkuName( productHierarchyUpdate.getSkuName());
		this.hierarchy.setSkuCodeLevel(productHierarchyUpdate.getSkuCodeLevel());
		this.hierarchy.setSubClass(productHierarchyUpdate.getSubClass());
		this.hierarchy.setSubClassName(productHierarchyUpdate.getSubClassName());
		this.hierarchy.setSubClassLevel(productHierarchyUpdate.getSubClassLevel());
		this.hierarchy.setClazz(productHierarchyUpdate.getClazz());
		this.hierarchy.setClassName(productHierarchyUpdate.getClassName());
		this.hierarchy.setClassLevel(productHierarchyUpdate.getClassLevel());
		this.hierarchy.setSubDepartment(productHierarchyUpdate.getSubDepartment());
		this.hierarchy.setSubDepartmentName(productHierarchyUpdate.getSubDepartmentName());
		this.hierarchy.setSubDepartmentLevel(productHierarchyUpdate.getSubDepartmentLevel());
		this.hierarchy.setDepartment(productHierarchyUpdate.getDepartment());
		this.hierarchy.setDepartmentName(productHierarchyUpdate.getDepartmentName());
		this.hierarchy.setDepartmentLevel(productHierarchyUpdate.getDepartmentLevel());
		this.hierarchy.setDivision(productHierarchyUpdate.getDivision());
		this.hierarchy.setDivisionName(productHierarchyUpdate.getDivisionName());
		this.hierarchy.setDivisionLevel(productHierarchyUpdate.getDivisionLevel());
		}

	
	

}