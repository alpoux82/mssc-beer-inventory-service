package guru.springframework.msscbeerinventoryservice.services;

import guru.sfg.brewery.model.events.AllocateOrderRequest;
import guru.sfg.brewery.model.events.AllocateOrderResult;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static guru.springframework.msscbeerinventoryservice.config.JmsConfig.ALLOCATE_ORDER_QUEUE;
import static guru.springframework.msscbeerinventoryservice.config.JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE;

@RequiredArgsConstructor
@Component
public class AllocationListener {

    private final AllocationService allocationService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = ALLOCATE_ORDER_QUEUE)
    public void listen(AllocateOrderRequest allocateOrderRequest) {
        AllocateOrderResult.AllocateOrderResultBuilder builder = AllocateOrderResult.builder();
        builder.beerOrderDto(allocateOrderRequest.getBeerOrderDto());
        try {
            Boolean allocationResult = allocationService.allocateOrder(allocateOrderRequest.getBeerOrderDto());
            if (allocationResult)
                builder.pendingInventory(false);
            else
                builder.pendingInventory(true);
        } catch (Exception e) {
            builder.allocationError(true);
        }
        jmsTemplate.convertAndSend(ALLOCATE_ORDER_RESPONSE_QUEUE, builder.build());
    }
}
