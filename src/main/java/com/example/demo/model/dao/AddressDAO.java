package com.example.demo.model.dao;

import com.example.demo.model.Address;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface AddressDAO extends ListCrudRepository<Address, Long> {
    List<Address> findByUser_Id(Long id);

    /*Optional<Address> findById(Long addressId);*/
}
