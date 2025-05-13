package org.utn.tup.backinventory.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.tup.backinventory.Dto.PostItemDto;
import org.utn.tup.backinventory.Entity.ItemEntity;
import org.utn.tup.backinventory.Service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @PostMapping("/add")
    public ResponseEntity<PostItemDto> createTeacherForAdmin(PostItemDto dto){
        return new ResponseEntity<>(service.addItem(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemEntity>> getTeachers(){
        //TODO: AGREGAR CAPACIDAD DE FILTRADO
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ItemEntity> getTeacherById(Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemEntity> createTeacherForAdmin(ItemEntity entity){
        return new ResponseEntity<>(service.updateItem(entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteItem(Long id){
        service.delteItem(id);
        return new ResponseEntity<>("Deleted item", HttpStatus.OK);
    }
}
