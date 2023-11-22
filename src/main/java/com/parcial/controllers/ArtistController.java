package com.parcial.controllers;

import com.parcial.entitys.Artist;
import com.parcial.entitys.Dtos.ArtistDto;
import com.parcial.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> findArtist(){
        try {
            List<Artist> artists = artistService.findAll();
            return ResponseEntity.ok(artists);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody ArtistDto entity) {
        try{
            Artist artist = artistService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(artist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable("id")Integer id, @RequestBody ArtistDto entity){
        try {
            Artist artist = artistService.update(id, entity);
            return ResponseEntity.ok(artist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable("id")Integer id){
        try{
            Artist artist = artistService.delete(id);
            return ResponseEntity.ok(artist);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable("id") Integer id){
        try {
            Artist artist = artistService.findById(id);
            return ResponseEntity.ok(artist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
