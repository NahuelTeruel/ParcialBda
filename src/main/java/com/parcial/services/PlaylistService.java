package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Playlist;
import com.parcial.entitys.Dtos.PlaylistDto;

public interface PlaylistService {

    Playlist findById(Integer id);

    List<Playlist> findAll();

    Playlist delete(Integer id);

    Playlist update(Integer id, PlaylistDto entity);

    Playlist add(PlaylistDto entity);
}

