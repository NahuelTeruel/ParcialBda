package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Artist;
import com.parcial.entitys.Dtos.ArtistDto;

public interface ArtistService {

    Artist findById(Integer id);

    List<Artist> findAll();

    Artist delete(Integer id);

    Artist update(Integer id, ArtistDto entity);

    Artist add(ArtistDto entity);
}

