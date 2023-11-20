package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Album;
import com.bda.ParcialBda.entities.dto.AlbumDto;

import java.util.List;

public interface AlbumService {
    Album getById(Integer id);
    List<Album> findAll();
    Album delete(Integer id);
    Album modify(Integer id, AlbumDto entity);
    Album add(AlbumDto entity);
}
