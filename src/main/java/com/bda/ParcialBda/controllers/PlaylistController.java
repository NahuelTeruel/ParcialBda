package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Playlist;
import com.bda.ParcialBda.entities.dto.PlaylistDto;
import com.bda.ParcialBda.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    @Autowired
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Playlist>> findAll() {
        List<Playlist> playlist = playlistService.findAll();
        return ResponseEntity.ok(playlist);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getById(@PathVariable("id") Integer id) {
        try {
            Playlist playlist = playlistService.getById(id);
            return ResponseEntity.ok(playlist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> delete(@PathVariable("id") Integer id) {
        try {
            Playlist playlist = playlistService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(playlist);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Playlist> add(@RequestBody PlaylistDto entity){
        try {
            Playlist playlist = playlistService.add(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body(playlist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> modify(@PathVariable("id") Integer id,@RequestBody PlaylistDto entity) {
        try {
            Playlist playlist = playlistService.modify(id, entity);

            return ResponseEntity.status(HttpStatus.OK).body(playlist);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
