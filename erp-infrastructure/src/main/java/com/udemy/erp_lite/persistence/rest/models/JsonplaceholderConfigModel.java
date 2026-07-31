package com.udemy.erp_lite.persistence.rest.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "jsonplaceholder.api")
public record JsonplaceholderConfigModel(
        @NotBlank(message = "JsonPlaceholder base URL must not be blank.")
        String baseUrl,

        @NotBlank(message = "JsonPlaceholder users endpoint must not be blank.")
        String usersEndpoint,

        @Positive(message = "Connect timeout must be greater than zero.")
        int connectTimeout,

        @Positive(message = "Record timeout must be greater than zero.")
        int readTimeout,

        @NotNull(message = "JsonPlaceholder enabled flag must not be null")
        String enabled
){
    public String usersUrl(){
        return baseUrl + usersEndpoint;
    }
}

