package com.parcial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.entitys.Playlist;
import com.parcial.entitys.Dtos.PlaylistDto;
import com.parcial.repositories.PlaylistRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;
    
    @Override
    public List<Playlist> findAll()  {
        return playlistRepository.findAll();
    }
    @Override
    public Playlist findById(Integer playlistId) {
        return playlistRepository.findById(playlistId).orElseThrow();
    }

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
    public Playlist update(Integer playlistId, PlaylistDto entity) {
        Optional<Playlist> playlist = Optional.of(playlistRepository.findById(playlistId).orElseThrow());
        if (playlist.isPresent()){
            playlist.get().setName(entity.getName());
            return playlistRepository.save(playlist.get());}
        else {
            throw new NoSuchElementException();
        }
    }
}
