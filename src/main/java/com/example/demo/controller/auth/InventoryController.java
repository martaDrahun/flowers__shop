package com.example.demo.controller.auth;

import com.example.demo.model.Inventory;
import com.example.demo.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryService.save(inventory);
        return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.findAll();
        return new ResponseEntity<>(inventoryList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory newInventory) {
        Optional<Inventory> existingInventoryOptional = inventoryService.findById(id);
        if (existingInventoryOptional.isPresent()) {
            Inventory existingInventory = existingInventoryOptional.get();
            existingInventory.setId(newInventory.getId());
            Inventory updatedInventory = inventoryService.save(newInventory);
            return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
            Optional<Inventory> inventory = inventoryService.findById(id);
            if (inventory.isPresent()) {
                inventoryService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
