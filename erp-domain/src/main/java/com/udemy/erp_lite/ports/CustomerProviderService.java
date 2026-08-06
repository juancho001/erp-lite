package com.udemy.erp_lite.ports;

import com.udemy.erp_lite.customer.CustomerInfo;

import java.util.Optional;

/**
 *  Port for external service for JSONPlaceholder
 */
public interface CustomerProviderService {

    Optional<CustomerInfo> findById(Long id);
    boolean existsById(Long id);
}