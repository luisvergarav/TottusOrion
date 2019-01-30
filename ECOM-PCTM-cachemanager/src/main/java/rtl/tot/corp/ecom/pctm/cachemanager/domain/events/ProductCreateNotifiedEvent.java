package rtl.tot.corp.ecom.pctm.cachemanager.domain.events;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.input.asb.EventDomain;

@JsonIgnoreProperties({"mapper", "entityType"})
public class ProductCreateNotifiedEvent implements EventDomain{

			
		private final ObjectMapper mapper = new ObjectMapper();
		 
		private String sku;
		
		@Override
		@JsonIgnore
		public String getEntityId() {
			// TODO Auto-generated method stub
			return sku;
		}

		@Override
		@JsonIgnore
		public String getMetadata() {
			String jsonValue;
	        try {
	            jsonValue = mapper.writeValueAsString(this);
	        } catch (JsonProcessingException e) {
	            jsonValue = super.toString();
	        }
	        return jsonValue;
		}

		@Override
		public String getEntityType() {
			return getClass().getName();
		}

		public ObjectMapper getMapper() {
			return mapper;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		
		


}
