package rtl.tot.corp.ecom.pctm.cachemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import com.microsoft.azure.spring.data.documentdb.repository.config.EnableDocumentDbRepositories;

@SpringBootApplication
//@EnableDocumentDbRepositories("rtl.tot.corp.ecom.pctm.cachemanager.domain")
public class EcomPctmCachemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomPctmCachemanagerApplication.class, args);
	}

}

