package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model.ProductAggregate;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model.ProductService;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.Command;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.ProductServiceApplication;

@Service
public class ProductServiceApplicationImpl implements ProductServiceApplication {

	@Autowired
	ProductService service;
	ProductAggregate aggregate;

	public boolean addProduct(CreateProductCommandImpl cmd) {
		
		aggregate = new  ProductAggregate.Builder()
				.productId(cmd.getSku())
				.tradeMark(cmd.getTradeMark())
				.classDescription(cmd.getClassDescription())
				.clazz(cmd.getClazz())
				.departDescription(cmd.departmentDescription)
				.department(cmd.getDepartment())
				.skuDescription(cmd.getSkuDescription())
				.division(cmd.getDivision())
				.divisionDesc(cmd.getDivisionDescription())
				.ean(cmd.getEan())
				.levelId(cmd.getLevelID())
				.model(cmd.getModel())
				.productType(cmd.getProductType())
				.provider(cmd.getProvider())
				.saleUnit(cmd.getSaleUnit())
				.skuCode(cmd.skuCode)
				.skuCodeDescription(cmd.getSkuCodeDescription())
				.skuDescription(cmd.getSkuDescription())
				.skuFlejeDescription(cmd.getSkuFlejeDescription())
				.skuPosDescription(cmd.getSkuPosDescription())
				.state(cmd.getState())
				.subClass(cmd.getSubClass())
				.subClassDescription(cmd.getSubClassDescription())
				.subDepartment(cmd.getSubDepartment())
				.subDepartmentDescription(cmd.getSubDepartmentDescription())
				.tradeMark(cmd.getTradeMark())
				.build();
		if (this.aggregate.addProduct(service))
			return true;
		else
			return false;

	}

}
