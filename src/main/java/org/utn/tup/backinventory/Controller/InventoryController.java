package org.utn.tup.backinventory.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.tup.backinventory.Dto.ItemPostDto;
import org.utn.tup.backinventory.Entity.ItemEntity;
import org.utn.tup.backinventory.Service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @PostMapping("/create")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemPostDto dto){
        return new ResponseEntity<>(service.addItem(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemEntity>> getItems(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemEntity> getItemById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemEntity> updateItem(@PathVariable Long id, @RequestBody ItemEntity itemEntity){
        itemEntity.setId(id);
        return new ResponseEntity<>(service.updateItem(itemEntity), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id){
        service.delteItem(id);
        return new ResponseEntity<>("Deleted item", HttpStatus.OK);
    }
}
