package com.ecomerce.android.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecomerce.android.dto.CustomerDTO;
import com.ecomerce.android.model.Customer;

public interface CustomerService {
    CustomerDTO getCustomerById(String name);
    
    public List<CustomerDTO> findAll();

    Boolean changeAvatar(String name, MultipartFile file) throws Exception;

    public <S extends Customer> boolean save(S entity); 
    
    void updateCustomer(CustomerDTO customerDTO);
}
