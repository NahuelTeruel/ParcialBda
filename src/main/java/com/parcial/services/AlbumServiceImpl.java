package com.parcial.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.entitys.Album;
import com.parcial.entitys.Artist;
import com.parcial.entitys.Dtos.AlbumDto;
import com.parcial.repositories.AlbumRepository;


@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistService artistService;

     @Override
    public Album findById(Integer id) {
        return albumRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album delete(Integer id) {
        Album album = albumRepository.findById(id).orElseThrow();
        albumRepository.delete(album);
        return album;
    }

    @Override
    public Album update(Integer id, AlbumDto entity) {
        Optional<Album> album = Optional.of(albumRepository.findById(id).orElseThrow());
        Optional<Artist> artist = Optional.of(artistService.findById(entity.getArtistId()));

        if(album.isPresent() && artist.isPresent()){
            album.get().setTitle(entity.getTitle());
            album.get().setArtist(artist.get());
            return albumRepository.save(album.get());
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Album add(AlbumDto entity) {
        Album album = new Album();
        Optional<Artist> artista = Optional.of(artistService.findById(entity.getArtistId()));
        if (artista.isPresent()){
            album.setTitle(entity.getTitle());
            album.setArtist(artista.get());
            return albumRepository.save(album);
        }
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }

    
} 

