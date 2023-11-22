package com.parcial.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.entitys.Artist;
import com.parcial.entitys.Dtos.ArtistDto;
import com.parcial.repositories.ArtistRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Integer id) { 
        return artistRepository.findById(id).orElseThrow();
    }

    @Override
    public Artist delete(Integer id) {
        Artist artist = artistRepository.findById(id).orElseThrow();
        artistRepository.delete(artist);
        return artist;
    }

    @Override
    public Artist add(ArtistDto entity) {
        Artist artist = new Artist();
        artist.setName(entity.getName());
        return artistRepository.save(artist);
    }

    @Override
    public Artist update(Integer id, ArtistDto entity) {
        Optional<Artist> artist = Optional.of(artistRepository.findById(id).orElseThrow());
        if (artist.isPresent()){
            artist.get().setName(entity.getName());
            return artistRepository.save(artist.get());}
        else {
            throw new NoSuchElementException();
        }
    }

}