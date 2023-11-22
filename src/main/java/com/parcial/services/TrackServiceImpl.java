package com.parcial.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.entitys.Album;
import com.parcial.entitys.Genre;
import com.parcial.entitys.Track;
import com.parcial.entitys.Dtos.TrackDto;
import com.parcial.repositories.TrackRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private AlbumService albumService;
   

    @Override
    public Track findById(Integer id) {
        return trackRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track delete(Integer id) {
        Track track = trackRepository.findById(id).orElseThrow();
        trackRepository.delete(track);
        return track;
    }

    @Override
    public Track update(Integer id, TrackDto entity) {
        Optional<Track> track = Optional.of(trackRepository.findById(id).orElseThrow());


        Optional<Album> album = Optional.of(albumService.findById(entity.getAlbumId()));
        
        
        Optional<Genre> genre = Optional.of(genreService.findById(entity.getGenreId()));



        if(track.isPresent() && album.isPresent() && genre.isPresent())
        {
            
            track.get().setAlbum(album.get());
            track.get().setBytes(entity.getBytes());
            track.get().setComposer(entity.getComposer());
            track.get().setGenre(genre.get());
            track.get().setMediaTypeId(entity.getMediaTypeId());
            track.get().setMilliseconds(entity.getMilliseconds());
            track.get().setName(entity.getName());
            track.get().setUnitPrice(entity.getUnitPrice());

            return trackRepository.save(track.get());
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Track add(TrackDto entity) {
        Track track = new Track();
        Optional<Album> album = Optional.of(albumService.findById(entity.getAlbumId()));
        Optional<Genre> genre = Optional.of(genreService.findById(entity.getGenreId()));

        if(album.isPresent() && genre.isPresent())
        {
            
            track.setAlbum(album.get());
            track.setBytes(entity.getBytes());
            track.setComposer(entity.getComposer());
            track.setGenre(genre.get());
            track.setMediaTypeId(entity.getMediaTypeId());
            track.setMilliseconds(entity.getMilliseconds());
            track.setName(entity.getName());
            track.setUnitPrice(entity.getUnitPrice());

            return trackRepository.save(track);
        }else {
            throw new NoSuchElementException();
        }
    }
}
