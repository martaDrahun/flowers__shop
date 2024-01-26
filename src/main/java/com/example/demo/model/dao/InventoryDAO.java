package com.example.demo.model.dao;

import com.example.demo.model.Inventory;
import org.springframework.data.repository.ListCrudRepository;

public interface InventoryDAO extends ListCrudRepository<Inventory, Long> {
}
