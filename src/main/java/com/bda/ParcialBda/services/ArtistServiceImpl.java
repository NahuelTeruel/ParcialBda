package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Artist;
import com.bda.ParcialBda.entities.dto.ArtistDto;
import com.bda.ParcialBda.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    public ArtistServiceImpl(ArtistRepository artistRepository){this.artistRepository = artistRepository;}
    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getById(Integer id) { return artistRepository.findById(id).orElseThrow();}

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
    public Artist modify(Integer id, ArtistDto entity) {
        Optional<Artist> artist = Optional.of(artistRepository.findById(id).orElseThrow());
        if (artist.isPresent()){
            artist.get().setName(entity.getName());
            return artistRepository.save(artist.get());}
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
