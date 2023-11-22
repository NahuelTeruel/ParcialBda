package com.parcial.controllers;

import com.parcial.entitys.Album;
import com.parcial.entitys.Dtos.AlbumDto;
import com.parcial.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> findAlbum(){
        try {
            List<Album> albums = albumService.findAll();
            return ResponseEntity.ok(albums);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody AlbumDto entity) {
        try{
            Album album = albumService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable("id")Integer id, @RequestBody AlbumDto entity){
        try {
            Album album = albumService.update(id, entity);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable("id")Integer id){
        try{
            Album album = albumService.delete(id);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") Integer id){
        try {
            Album album = albumService.findById(id);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
