package rtl.tot.corp.ecom.pctm.product.productcatalogcmd;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.CreateProductCommandImpl;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.DecoratorCreateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.controllers.ProductController;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.Product;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductCatalogCmdApplicationTests {

	@Autowired
    private MockMvc mvc;
	private final ObjectMapper mapper = new ObjectMapper();
	 
 

	@Test
	public void contextLoads() {
	}

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200()
	  throws Exception {
	 
		Product prd = new Product();
		prd.setSku("1");
	 
	    mvc.perform(post("/MREX/PRMG/v1.0/PRODUCT")
	      .header("Country", "CL")
	      .header("Commerce", "Tottus")
	      .header("Channel", "PMM")
	      .content(mapper.writeValueAsString(prd))
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	
	
	
}





