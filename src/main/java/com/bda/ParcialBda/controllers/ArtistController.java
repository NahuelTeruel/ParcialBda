package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Artist;
import com.bda.ParcialBda.entities.dto.ArtistDto;
import com.bda.ParcialBda.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    @Autowired
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Artist>> findAll() {
        List<Artist> artists = artistService.findAll();
        return ResponseEntity.ok(artists);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable("id") Integer id) {
        try {
            Artist artist = artistService.getById(id);
            return ResponseEntity.ok(artist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Artist> delete(@PathVariable("id") Integer id) {
        try {
            Artist artist = artistService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(artist);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Artist> add(@RequestBody ArtistDto entity){
        try {
            Artist artist = artistService.add(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body(artist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Artist> modify(@PathVariable("id") Integer id,@RequestBody ArtistDto entity) {
        try {
            Artist artist = artistService.modify(id, entity);

            return ResponseEntity.status(HttpStatus.OK).body(artist);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
