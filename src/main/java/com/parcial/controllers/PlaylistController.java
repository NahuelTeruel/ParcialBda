package com.parcial.controllers;

import com.parcial.entitys.Playlist;
import com.parcial.entitys.Dtos.PlaylistDto;
import com.parcial.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<Playlist>> findPlaylist(){
        try {
            List<Playlist> playlists = playlistService.findAll();
            return ResponseEntity.ok(playlists);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Playlist> addPlaylist(@RequestBody PlaylistDto entity) {
        try{
            Playlist playlist = playlistService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(playlist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("id")Integer id, @RequestBody PlaylistDto entity){
        try {
            Playlist playlist = playlistService.update(id, entity);
            return ResponseEntity.ok(playlist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable("id")Integer id){
        try{
            Playlist playlist = playlistService.delete(id);
            return ResponseEntity.ok(playlist);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Integer id){
        try {
            Playlist playlist = playlistService.findById(id);
            return ResponseEntity.ok(playlist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
