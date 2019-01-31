package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.db.cosmos;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model.Product;

@Repository
public interface ProductRepository extends DocumentDbRepository<Product, Long> {
 
}
