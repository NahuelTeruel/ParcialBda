package com.parcial.controllers;

import com.parcial.entitys.Track;
import com.parcial.entitys.Dtos.TrackDto;
import com.parcial.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public ResponseEntity<List<Track>> findTrack(){
        try {
            List<Track> tracks = trackService.findAll();
            return ResponseEntity.ok(tracks);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Track> addTrack(@RequestBody TrackDto entity) {
        try{
            Track track = trackService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(track);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable("id")Integer id, @RequestBody TrackDto entity){
        try {
            Track track = trackService.update(id, entity);
            return ResponseEntity.ok(track);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Track> deleteTrack(@PathVariable("id")Integer id){
        try{
            Track track = trackService.delete(id);
            return ResponseEntity.ok(track);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable("id") Integer id){
        try {
            Track track = trackService.findById(id);
            return ResponseEntity.ok(track);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
