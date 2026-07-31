package com.udemy.erp_lite.persistence.rest.dto;

public record AddressDTO(
        String street,
        String suite,
        String city,
        String zipcode,
        GeoDTO geo
) {}
