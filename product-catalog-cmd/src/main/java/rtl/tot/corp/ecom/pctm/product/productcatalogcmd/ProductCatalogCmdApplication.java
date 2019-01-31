package rtl.tot.corp.ecom.pctm.product.productcatalogcmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.microsoft.azure.servicebus.QueueClient;

@SpringBootApplication
public class ProductCatalogCmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogCmdApplication.class, args);
		
	}

}

