package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Artist;
import com.bda.ParcialBda.entities.dto.ArtistDto;

import java.util.List;

public interface ArtistService {
    List<Artist> findAll();

    Artist getById(Integer id);

    Artist delete(Integer id);

    Artist add(ArtistDto entity);

    Artist modify(Integer id, ArtistDto entity);
}
