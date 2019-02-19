package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Assortment;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Attribute;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Conservation;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.EanSecundary;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.Hierarchy;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.model.LogisticAttributes;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CreateProductCommand;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.Product;

@Data
public class CreateProductCommandImpl implements CreateProductCommand<Product> {
	
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


	public CreateProductCommandImpl(Product request) {
		super();
		this.brand = request.getBrand();
		this.codeSUNAT = request.getCodeSUNAT();
		this.codeSupplier = request.getCodeSupplier();
		this.description = request.getDescription();
		this.ean = request.getEan();
		this.flejeDescription = request.getFlejeDescription();
		this.levelId = request.getLevelId();
		this.model = request.getModel();
		this.nameCasePack = request.getNameCasePack();
		this.nameSupplier = request.getNameSupplier();
		this.posDescription = request.getPosDescription();
		this.productType = request.getProductType();
		this.qtyCasePack = request.getQtyCasePack();
		this.saleUnit = request.getSaleUnit();
		this.sku = request.getSku();
		this.status = request.getStatus();
		this.unitMeasure = request.getUnitMeasure();
		if (request.getAssortment() != null) {
			this.assortment.setStore(request.getAssortment().getStore());
		}
		if (request.getAttribute() != null){
			for (rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.Attribute 
					a: request.getAttribute()) {
				Attribute attribute = new Attribute();
				attribute.setNameAttribute(a.getNameAttribute());
				attribute.setValue(a.getValue());
				this.attribute.add(attribute);
			}
		}
		
		if (request.getConservation() != null) {
			this.conservation.setConservation(request.getConservation().getConservation());
			this.conservation.setEndDateSanitaryRegistration(request.getConservation().getEndDateSanitaryRegistration());
			this.conservation.setNumSanitaryRegistration(request.getConservation().getNumSanitaryRegistration());
			this.conservation.setTmr(request.getConservation().getTmr());
			this.conservation.setStartDateSanitaryRegistration(request.getConservation().getStartDateSanitaryRegistration());
			this.conservation.setTvu(request.getConservation().getTvu());
			this.conservation.setTypeSanitaryRegistration(request.getConservation().getTypeSanitaryRegistration());
		}
		
		if (request.getEanSecundary() != null) {
			 for(rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.EanSecundary 
					e :request.getEanSecundary()) {
				 EanSecundary eanSecundary = new EanSecundary();
				 eanSecundary.setEanSecundary(e.getEanSecundary());
				 this.eanSecundary.add(eanSecundary);
			}
		}
		
		if (request.getHierarchy() != null) {
			this.hierarchy.setClassLevel(request.getHierarchy().getClassLevel());
			this.hierarchy.setClassName(request.getHierarchy().getClassName());
			this.hierarchy.setClazz(request.getHierarchy().getClazz());
			this.hierarchy.setDepartment(request.getHierarchy().getDepartment());
			this.hierarchy.setDepartmentLevel(request.getHierarchy().getDepartmentLevel());
			this.hierarchy.setDepartmentName(request.getHierarchy().getDepartmentName());
			this.hierarchy.setDivision(request.getHierarchy().getDivision());
			this.hierarchy.setDivisionLevel(request.getHierarchy().getDivisionLevel());
			this.hierarchy.setDivisionName(request.getHierarchy().getDivisionName());
			this.hierarchy.setSkuCode(request.getHierarchy().getSkuCode());
			this.hierarchy.setSkuCodeLevel(request.getHierarchy().getSkuCodeLevel());
			this.hierarchy.setSkuName(request.getHierarchy().getSkuName());
			this.hierarchy.setSubClass(request.getHierarchy().getSubClass());
			this.hierarchy.setSubClassLevel(request.getHierarchy().getSubClassLevel());
			this.hierarchy.setSubClassName(request.getHierarchy().getSubClassName());
			this.hierarchy.setSubDepartment(request.getHierarchy().getSubDepartment());
			this.hierarchy.setSubDepartmentLevel(request.getHierarchy().getSubDepartmentLevel());
			this.hierarchy.setSubDepartmentName(request.getHierarchy().getSubDepartmentName());
			
		}
		
		if (request.getLogisticAttributes() != null){
			this.logisticAttributes.setHigh(request.getLogisticAttributes().getHigh());
			this.logisticAttributes.setHighCasePack(request.getLogisticAttributes().getHighCasePack());
			this.logisticAttributes.setLength(request.getLogisticAttributes().getLength());
			this.logisticAttributes.setLengthCasePack(request.getLogisticAttributes().getLengthCasePack());
			this.logisticAttributes.setPalletHi(request.getLogisticAttributes().getPalletHi());
			this.logisticAttributes.setPalletTier(request.getLogisticAttributes().getPalletTier());
			this.logisticAttributes.setUnitMeasure(request.getLogisticAttributes().getUnitMeasure());
			this.logisticAttributes.setUnitMeasureCasePack(request.getLogisticAttributes().getUnitMeasureCasePack());
			this.logisticAttributes.setUnitWeight(request.getLogisticAttributes().getUnitWeight());
			this.logisticAttributes.setValueWeight(request.getLogisticAttributes().getValueWeight());
			this.logisticAttributes.setWidth(request.getLogisticAttributes().getWidth());
			this.logisticAttributes.setWidthCasePack(request.getLogisticAttributes().getWidthCasePack());
			
		}
	}

	
	

}