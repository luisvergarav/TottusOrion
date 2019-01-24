package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.eda.internal;

import java.util.Date;

import lombok.Data;

@Data
public abstract class AbstractEvent implements Event {

  /**
   * Returns the event type as a {@link Class} object
   * In this example, this method is used by the {@link EventDispatcher} to
   * dispatch events depending on their type.
   *
   * @return the AbstractEvent type as a {@link Class}.
   */

	
	 String eventId;
	 String eventType;
	 String entityId;
	 String entityType;
	 Long timestamp;
	 Date datetime;
	 String version;
	 String country;
	 String commerce;
	 String channel;
	 String mimeType;
	 String metadata;

	 
	 
	 public Class<? extends Event> getType() {
    return getClass();
  }
}