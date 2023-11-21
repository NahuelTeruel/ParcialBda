package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Playlist;
import com.bda.ParcialBda.entities.dto.PlaylistDto;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();

    Playlist getById(Integer playlistId);

    Playlist delete(Integer playlistId);

    Playlist add(PlaylistDto entity);

    Playlist modify(Integer playlistId, PlaylistDto entity);
}
