package com.udemy.erp_lite.persistence.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompanyDTO(
        String name,
        @JsonProperty("catchPhrase")
        String cp /*catchPhrase*/,
        String bs
) {}
