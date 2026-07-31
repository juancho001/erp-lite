package com.udemy.erp_lite.order.events;

import com.udemy.erp_lite.common.DomainEvent;
import com.udemy.erp_lite.order.OrderId;

import java.time.Instant;

/**
 * Emitted when order is cancelled.
 * If was CONFIRMED, stock must be released.
 *
 * @param orderId   the order identifier
 * @param reason    the cancellation reason
 * @param timestamp the event timestamp
 */
public record OrderCancelled(
        OrderId orderId,
        String reason,
        Instant timestamp
) implements DomainEvent {
}