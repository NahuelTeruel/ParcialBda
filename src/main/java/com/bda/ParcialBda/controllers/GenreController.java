package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Genre;
import com.bda.ParcialBda.entities.dto.GenreDto;
import com.bda.ParcialBda.services.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> findAll(){
        try {
            List<Genre> genres = genreService.findAll();
            return ResponseEntity.ok(genres);
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getById(Integer id){
        try {
            Genre genre = genreService.getById(id);
            return ResponseEntity.ok(genre);
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> modify(@PathVariable("id") Integer id, @RequestBody GenreDto entity){
        try {
            Genre genre = genreService.modify(id, entity);
            return ResponseEntity.ok(genre);
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Genre> add(GenreDto entity){
        try{
            Genre genre = genreService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(genre);
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Genre> delete(@PathVariable("id") Integer id){
        try {
            Genre genre = genreService.delete(id);
            return ResponseEntity.ok(genre);
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
