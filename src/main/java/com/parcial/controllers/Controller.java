package com.parcial.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.entitys.Album;
import com.parcial.entitys.Artist;
import com.parcial.entitys.Customer;
import com.parcial.entitys.Genre;
import com.parcial.entitys.Invoice;
import com.parcial.entitys.Playlist;
import com.parcial.entitys.Track;
import com.parcial.entitys.Dtos.AlbumDto;
import com.parcial.entitys.Dtos.ArtistDto;
import com.parcial.services.AlbumService;
import com.parcial.services.ArtistService;
import com.parcial.services.CustomerService;
import com.parcial.services.GenreService;
import com.parcial.services.InvoiceService;
import com.parcial.services.PlaylistService;
import com.parcial.services.TrackService;


@RestController
@RequestMapping("/api/")
public class Controller {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private TrackService trackService;
 

    @GetMapping("/album")
    public ResponseEntity<List<Album>> findAlbum(){
        try {
            List<Album> albums = albumService.findAll();
            return ResponseEntity.ok(albums);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/artist")
    public ResponseEntity<List<Artist>> findArtist(){
        try {
            List<Artist> artists = artistService.findAll();
            return ResponseEntity.ok(artists);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> findCustomer(){
        try {
            List<Customer> customers = customerService.findAll();
            return ResponseEntity.ok(customers);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Genre>> findGenre(){
        try {
            List<Genre> genres = genreService.findAll();
            return ResponseEntity.ok(genres);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> findInvoice(){
        try {
            List<Invoice> invoices = invoiceService.findAll();
            return ResponseEntity.ok(invoices);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/playlist")
    public ResponseEntity<List<Playlist>> findPlaylist(){
        try {
            List<Playlist> playlists = playlistService.findAll();
            return ResponseEntity.ok(playlists);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/track")
    public ResponseEntity<List<Track>> findTrack(){
        try {
            List<Track> tracks = trackService.findAll();
            return ResponseEntity.ok(tracks);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    
    @PostMapping("/album")
    public ResponseEntity<Album> add(AlbumDto entity) {
        try{
        Album album = albumService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/artist")
    public ResponseEntity<Artist> add(ArtistDto entity) {
        try{
        Artist artist = artistService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(artist);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}















/* 
    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable("id") Integer id){
        try {
            Album album = albumService.findById(id);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<Album> update(@PathVariable("id")Integer id, @RequestBody AlbumDto entity){
        try {
            Album album = albumService.update(id, entity);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Album> add(AlbumDto entity) {
        try{
        Album album = albumService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(album);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Album> delete(@PathVariable("id")Integer id){
        try{
            Album album = albumService.delete(id);
            return ResponseEntity.ok(album);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    */
