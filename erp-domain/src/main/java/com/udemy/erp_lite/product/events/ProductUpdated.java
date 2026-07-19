package com.udemy.erp_lite.product.events;

import com.udemy.erp_lite.common.DomainEvent;
import com.udemy.erp_lite.product.ProductId;

import java.time.Instant;

/**
 * Emitted when product info is updated.
 * TRIGGERS sync to MongoDB.
 *
 * @param productId the product identifier
 * @param timestamp the event timestamp
 */
public record ProductUpdated(
        ProductId productId,
        Instant timestamp
) implements DomainEvent {
}