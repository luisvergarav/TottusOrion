package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.ports;

import java.util.Map;

public interface IncommingMessageListener {

    void notify( final String requestJMSMessage, Map<String, String> jmsHeaders ) throws Exception;    
}