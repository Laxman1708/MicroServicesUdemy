package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    public CustomerDto getCustomerById(UUID custId);
    public CustomerDto saveCustomer(CustomerDto customerDto);
    public void updateCustomer(UUID id, CustomerDto customerDto);
    public void deleteCusomer(UUID id);
}
