package com.udemy.erp_lite.persistence.rest.config;


import com.udemy.erp_lite.persistence.rest.models.JsonplaceholderConfigModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestClient;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class RestClientConfig {
    private final JsonplaceholderConfigModel jsonConfig;

    @Bean(name = "jsonplaceholder")
    @ConditionalOnProperty(
            prefix = "jsonplaceholder",
            name = "enabled",
            havingValue = "true",
            matchIfMissing = true
    )
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl(jsonConfig.baseUrl())
                .requestInterceptors(interceptorS ->{
                    interceptorS.add(LogInterceptor());
                    interceptorS.add(errorLogInterceptor());
                })
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    httpHeaders.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
                })
                .build();
    }


    private ClientHttpRequestInterceptor LogInterceptor(){
        return (request, body, execution) -> {
            log.info("Calling  Jsonplaceholder API...");
            log.info("Method: {}",request.getMethod());
            log.info("URI: {}",request.getURI());
            log.info("Headers: {}",request.getHeaders());

            final long startTime = System.currentTimeMillis();
            ClientHttpResponse response = execution.execute(request, body);
            final long endTime = System.currentTimeMillis() - startTime;

            log.info("Status: {} ms",response.getStatusCode());
            log.info("Execution Time: {} ms",endTime);
            return response;
        };
    }


    private ClientHttpRequestInterceptor errorLogInterceptor(){
        return (request, body, execution) -> {
            try {
                return execution.execute(request,body);
            }catch (Exception e){
                log.error("Error Message:{}",e.getMessage());
                throw e;
            }
        };
    }



}
