package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.db.cosmos.ProductRepository;

@Service
@Slf4j
public class ProductService {

ProductRepository repository;

public ProductService(ProductRepository repository) {
	super();
	this.repository = repository;
}

public boolean addProduct(ProductAggregate productAgg){
	
	Product product = new Product();
	product.setSku(productAgg.productRootentity.getProductId());
	
	this.repository.save(product);
	log.info("Product Saved successful ", product);
	return true;
	
	
}

}
