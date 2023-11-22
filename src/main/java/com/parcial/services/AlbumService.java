package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Album;
import com.parcial.entitys.Dtos.AlbumDto;

public interface AlbumService {

    Album findById(Integer id);

    List<Album> findAll();

    Album delete(Integer id);

    Album update(Integer id, AlbumDto entity);

    Album add(AlbumDto entity);
}

