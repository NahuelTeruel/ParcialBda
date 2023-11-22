package com.parcial.controllers;

import com.parcial.entitys.Genre;
import com.parcial.entitys.Dtos.GenreDto;
import com.parcial.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<Genre>> findGenre(){
        try {
            List<Genre> genres = genreService.findAll();
            return ResponseEntity.ok(genres);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Genre> addGenre(@RequestBody GenreDto entity) {
        try{
            Genre genre = genreService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(genre);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id")Integer id, @RequestBody GenreDto entity){
        try {
            Genre genre = genreService.update(id, entity);
            return ResponseEntity.ok(genre);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable("id")Integer id){
        try{
            Genre genre = genreService.delete(id);
            return ResponseEntity.ok(genre);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Integer id){
        try {
            Genre genre = genreService.findById(id);
            return ResponseEntity.ok(genre);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
