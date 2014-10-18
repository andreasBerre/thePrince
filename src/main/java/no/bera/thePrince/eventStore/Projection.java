package no.bera.thePrince.eventStore;

import no.bera.serialized.Event;

public abstract class Projection {

    public Projection(EventStore eventStore) {
        eventStore.subscribe(getAggregateType(), this);
    }

    protected abstract AggregateType getAggregateType();

    public abstract void handleEvent(Event event);
}
