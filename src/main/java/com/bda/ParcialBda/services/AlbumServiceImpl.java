package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Album;
import com.bda.ParcialBda.entities.Artist;
import com.bda.ParcialBda.entities.dto.AlbumDto;
import com.bda.ParcialBda.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    @Override
    public Album getById(Integer id) {
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
    public Album modify(Integer id, AlbumDto entity) {
        Optional<Album> album = Optional.of(albumRepository.findById(id).orElseThrow());
        Optional<Artist> artist = Optional.of(artistService.getById((int) entity.getArtist()));

        if(album.isPresent() && artist.isPresent()){
            album.get().setTitle(entity.getTitle());
            album.get().setArtist(artist.get());
            return albumRepository.save(album.get());
        }
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }

    @Override
    public Album add(AlbumDto entity) {
        Album album = new Album();
        Optional<Artist> artista = Optional.of(artistService.getById((int) entity.getArtist()));
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
