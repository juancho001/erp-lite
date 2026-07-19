package com.udemy.erp_lite.product.events;

import com.udemy.erp_lite.common.DomainEvent;
import com.udemy.erp_lite.product.ProductId;
import com.udemy.erp_lite.product.ProductName;
import com.udemy.erp_lite.product.SKU;
import com.udemy.erp_lite.shared.Money;

import java.time.Instant;

/**
 * Emitted when a new product is created.
 * TRIGGERS sync to MongoDB (CQRS).
 *
 * @param productId the product identifier
 * @param sku       the product SKU
 * @param name      the product name
 * @param price     the product price
 * @param timestamp the event timestamp
 */
public record ProductCreated(
        ProductId productId,
        SKU sku,
        ProductName name,
        Money price,
        Instant timestamp
) implements DomainEvent {
}