package rtl.tot.corp.ecom.pctm.cachemanager.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

@Repository
@Primary
public interface ProductsRepository extends DocumentDbRepository<Product, Long> {
 
}
