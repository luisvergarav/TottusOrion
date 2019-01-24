package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.tools;

import java.io.IOException;
import java.io.StringWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert<T> implements Convert<T> {

	@Override
	public String convert(T class1) throws IOException {
		 
	    

		StringWriter writer = new StringWriter();
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.writeValue(writer, class1);
	    
	    return writer.toString();
		
		
	}

}