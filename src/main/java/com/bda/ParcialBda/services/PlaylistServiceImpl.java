package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Playlist;
import com.bda.ParcialBda.entities.dto.PlaylistDto;
import com.bda.ParcialBda.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    private final PlaylistRepository playlistRepository;
    public PlaylistServiceImpl(PlaylistRepository playlistRepository){this.playlistRepository = playlistRepository;}
    @Override
    public List<Playlist> findAll()  {
        return playlistRepository.findAll();
    }
    @Override
    public Playlist getById(Integer playlistId) { return playlistRepository.findById(playlistId).orElseThrow();}

    @Override
    public Playlist delete(Integer playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow();
        playlistRepository.delete(playlist);
        return playlist;
    }

    @Override
    public Playlist add(PlaylistDto entity) {
        Playlist playlist = new Playlist();
        playlist.setName(entity.getName());
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist modify(Integer playlistId, PlaylistDto entity) {
        Optional<Playlist> playlist = Optional.of(playlistRepository.findById(playlistId).orElseThrow());
        if (playlist.isPresent()){
            playlist.get().setName(entity.getName());
            return playlistRepository.save(playlist.get());}
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
