package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID custId);
}
