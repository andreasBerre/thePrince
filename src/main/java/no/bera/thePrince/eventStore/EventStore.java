package no.bera.thePrince.eventStore;

import no.bera.serialized.AggregateId;
import no.bera.serialized.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventStore {
    private Map<AggregateType, List<Projection>> subscriptions = new HashMap<>();
    private List<Event> events = new ArrayList<>();

    public List<Event> getEventsByAggregateId(AggregateId id) {
        List<Event> aggregateEvents = new ArrayList<>();

        for (Event event : events) {
            if (event.getAggregateId() == id)
                aggregateEvents.add(event);
        }

        return aggregateEvents;
    }

    public void storeEvents(List<Event> derivedEvents) {
        for (Event event : derivedEvents){
            events.add(event);
            sendToSubscribers(event);
        }
    }

    private void sendToSubscribers(Event event) {
        for (Projection projection : subscriptions.get(event.getAggregateType()))
            projection.handleEvent(event);

    }

    public void subscribe(AggregateType aggregateType, Projection projection) {
        if (subscriptions.get(aggregateType) == null)
            subscriptions.put(aggregateType, new ArrayList<Projection>());

        subscriptions.get(aggregateType).add(projection);
    }
}
