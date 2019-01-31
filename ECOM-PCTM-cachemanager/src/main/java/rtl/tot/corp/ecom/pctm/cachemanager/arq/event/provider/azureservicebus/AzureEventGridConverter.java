package rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.azureservicebus;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.microsoft.azure.eventgrid.models.EventGridEvent;

import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.Event;
import rtl.tot.corp.ecom.pctm.cachemanager.arq.event.provider.EventConverter;
import rtl.tot.corp.ecom.pctm.cachemanager.domain.events.EventType;

public class AzureEventGridConverter implements EventConverter<List<EventGridEvent>> {


	@Override
	public List<EventGridEvent> toMessage(Event event) {
		 List<EventGridEvent> eventsList = new ArrayList<>();
         
         eventsList.add(new EventGridEvent(
                 com.microsoft.azure.arm.utils.SdkContext.randomUuid(),
                 String.format(event.getChannel()),
                 event.getMetadata(),
                 event.getEventType(),
                 DateTime.now(),
                 "1.0"
             ));
		return eventsList;
       	}

	@Override
	public Event fromMessage(List<EventGridEvent> message) {
		// TODO Auto-generated method stub
		return null;
	}

}
