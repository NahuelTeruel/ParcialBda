package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Album;
import com.bda.ParcialBda.entities.dto.AlbumDto;
import com.bda.ParcialBda.services.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final AlbumService albumService;
    public AlbumController(AlbumService albumService) { this.albumService = albumService; }

    @GetMapping
    public ResponseEntity<List<Album>> findAll(){
        try {
            List<Album> albums = albumService.findAll();
            return ResponseEntity.ok(albums);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable("id") Integer id){
        try {
            Album album = albumService.getById(id);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> modify(@PathVariable("id") Integer id, @RequestBody AlbumDto entity){
        try {
            Album album = albumService.modify(id, entity);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Album> add(AlbumDto entity){
        try{
            Album album = albumService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Album> delete(@PathVariable("id") Integer id){
        try {
            Album album = albumService.delete(id);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
