package rtl.tot.corp.ecom.pctm.cachemanager.infraestructure.adapters.input.asb;

import java.util.Map;

public interface IncommingMessageListener {

    void notify( final String requestJMSMessage, Map<String, String> jmsHeaders ) throws Exception;    
}