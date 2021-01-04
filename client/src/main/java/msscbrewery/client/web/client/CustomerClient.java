package msscbrewery.client.web.client;

import msscbrewery.client.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class CustomerClient {

    private RestTemplate restTemplate;
    public CustomerClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }
    private String apihost;

    public void setApiHost(String apihost) {
        this.apihost = apihost;
    }
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    public CustomerDto getCustomer(UUID id) {
        return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+id.toString(), CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID id, CustomerDto customerDto) {
        restTemplate.put(apihost+CUSTOMER_PATH_V1+id.toString(), customerDto);
    }

    public void deleteCustomer(UUID id) {
        restTemplate.delete(apihost+CUSTOMER_PATH_V1+id);
    }
}
