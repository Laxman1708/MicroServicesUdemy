package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.BeerDto;
import msscbrewary.brewary.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID custId) {
        return CustomerDto.builder().id(UUID.randomUUID()).customerName("Laxman").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto
                .builder().customerName("Laxman").build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
    //todo implementation
    }

    @Override
    public void deleteCusomer(UUID id) {
        //todo implementation
    }
}
