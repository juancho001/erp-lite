package com.udemy.erp_lite.persistence.rest.adapters;


import com.udemy.erp_lite.customer.CustomerInfo;
import com.udemy.erp_lite.customer.CustomerProviderService;
import com.udemy.erp_lite.persistence.rest.dto.UserDTO;
import com.udemy.erp_lite.persistence.rest.models.JsonplaceholderConfigModel;
import com.udemy.erp_lite.persistence.mappers.CustomerMappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@Service
@Slf4j
public class JsonPlaceholderCustomerProviderAdapter implements CustomerProviderService {

    private final RestClient jsonClient;
    private final CustomerMappers customerMapper;
    private final String endpoint;

    public JsonPlaceholderCustomerProviderAdapter(
            @Qualifier("jsonplaceholder") RestClient restClient,
            CustomerMappers customerMapper,
            JsonplaceholderConfigModel jsonConfig) {
        this.jsonClient = restClient;
        this.customerMapper = customerMapper;
        this.endpoint = jsonConfig.usersEndpoint();
    }

    @Override
    public Optional<CustomerInfo> findById(Long id) {
        log.info("findById: {}",id);

        try{

            final UserDTO response = this.jsonClient
                    .get()
                    .uri(endpoint,id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(request, response1) -> {
                        log.error("Error on Client Side: {}",request);
                    })
                    .onStatus(HttpStatusCode::is5xxServerError,(request, response1) -> {
                        log.error("Error in Server Side {}",request);
                    })
                    .body(UserDTO.class);
            if(response == null){
                log.warn("No user found");
                return Optional.empty();
            }

            log.info("User found: {}",response);
            return Optional.of(this.customerMapper.toCustomerInfo(response));

        }catch (RestClientException restClientException){
            log.error("Error on findById while calling API..",restClientException);
            return Optional.empty();
        } catch (Exception exception) {
            log.error("Error on findById",exception);
            return Optional.empty();
        }
    }

    @Override
    public boolean existsById(Long id) {
        log.info("existsById: {}",id);
        return false;
    }
}
