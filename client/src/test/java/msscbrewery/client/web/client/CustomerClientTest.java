package msscbrewery.client.web.client;

import msscbrewery.client.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;
    @Test
    void getCustomer() {
        CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Vijay").id(UUID.randomUUID()).build();
        URI uri = customerClient.saveCustomer(customerDto);
        assertNotNull(uri);
        System.out.println("Saved object with URI: "+uri.toString());

    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Vijay").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}