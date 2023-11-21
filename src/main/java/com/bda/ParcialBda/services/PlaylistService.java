package com.bda.ParcialBda.services;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();

    Playlist getById(Integer playlistId);

    Playlist delete(Integer playlistId);

    Playlist add(PlaylistDto entity);

    Playlist modify(Integer playlistId, PlaylistDto entity);
}
