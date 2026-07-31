package com.udemy.erp_lite.order.events;

import com.udemy.erp_lite.common.DomainEvent;
import com.udemy.erp_lite.order.OrderId;

import java.time.Instant;

/**
 * Emitted when order transitions PENDING -> CONFIRMED.
 * TRIGGERS stock decrement.
 *
 * @param orderId   the order identifier
 * @param timestamp the event timestamp
 */
public record OrderConfirmed(
        OrderId orderId,
        Instant timestamp
) implements DomainEvent {
}