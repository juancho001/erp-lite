package com.udemy.erp_lite.order.events;


import com.udemy.erp_lite.common.DomainEvent;
import com.udemy.erp_lite.order.OrderId;
import com.udemy.erp_lite.shared.CustomerId;
import com.udemy.erp_lite.shared.Money;

import java.time.Instant;

/**
 * Emitted when a new order is created.
 *
 * @param orderId      the order identifier
 * @param customerId   the customer identifier
 * @param customerName the customer name
 * @param totalAmount  the total order amount
 * @param timestamp    the event timestamp
 */
public record OrderCreated(
        OrderId orderId,
        CustomerId customerId,
        String customerName,
        Money totalAmount,
        Instant timestamp
) implements DomainEvent {
}