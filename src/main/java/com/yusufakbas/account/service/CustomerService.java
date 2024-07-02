package com.yusufakbas.account.service;

import com.yusufakbas.account.dto.CustomerDto;
import com.yusufakbas.account.dto.converter.CustomerDtoConverter;
import com.yusufakbas.account.exception.CustomerNotFoundException;
import com.yusufakbas.account.model.Customer;
import com.yusufakbas.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }


    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
    }

}
