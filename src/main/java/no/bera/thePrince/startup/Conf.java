package no.bera.thePrince.startup;

import no.bera.thePrince.basket.BasketApplicationService;
import no.bera.thePrince.basket.BasketProjection;
import no.bera.thePrince.orders.OrderApplicationService;
import no.bera.thePrince.eventStore.EventStore;
import no.bera.thePrince.orders.OrderProjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {
    private final EventStore eventStore;

    public Conf() {
        this.eventStore = new EventStore();
    }

    @Bean
    public BasketApplicationService createBasketApplicationService() {
        return new BasketApplicationService(eventStore);
    }

    @Bean
    public OrderApplicationService createOrderApplicationService() {
        return new OrderApplicationService(eventStore);
    }

    @Bean
    public BasketProjection createBasketProjection() {
        return new BasketProjection(eventStore);
    }

    @Bean
    public OrderProjection createOrderProjection(){
        return new OrderProjection(eventStore);
    }
}

