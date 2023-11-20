package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Item;
import com.bda.ParcialBda.entities.dto.ItemDto;
import com.bda.ParcialBda.services.AlbumService;
import com.bda.ParcialBda.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/items")
public class ItemController {
    @Autowired
    private final ItemService itemService;
    public ItemController(AlbumService albumService) { this.itemService = itemService;}

    @GetMapping
    public ResponseEntity<List<Item>> findAll(){
        try {
            List<Item> items = itemService.findAll();
            return ResponseEntity.ok(items);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Integer id){
        try {
            Item item = itemService.getById(id);
            return ResponseEntity.ok(item);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> modify(@PathVariable("id") Integer id, @RequestBody ItemDto entity){
        try {
            Item item = itemService.modify(id, entity);
            return ResponseEntity.ok(item);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Item> add(ItemDto entity){
        try{
            Item item = itemService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(item);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable("id") Integer id){
        try {
            Item item = itemService.delete(id);
            return ResponseEntity.ok(item);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
