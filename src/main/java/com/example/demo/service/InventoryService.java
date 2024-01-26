package com.example.demo.service;

import com.example.demo.model.Inventory;
import com.example.demo.model.dao.InventoryDAO;

import java.util.List;
import java.util.Optional;

public class InventoryService {
    private InventoryDAO inventoryDAO;

    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public List<Inventory> getProducts() {
        return inventoryDAO.findAll();
    }

    public Inventory save(Inventory inventory) {

        return inventoryDAO.save(inventory);
    }

    public List<Inventory> findAll() {
        return inventoryDAO.findAll();
    }

    public Optional<Inventory> findById(Long id) {
          return inventoryDAO.findById(id);
    }

    public void deleteById(Long id) {
         inventoryDAO.deleteById(id);
    }
}
