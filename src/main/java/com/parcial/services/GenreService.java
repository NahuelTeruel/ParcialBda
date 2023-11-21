package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Genre;
import com.parcial.entitys.Dtos.GenreDto;

public interface GenreService {

    Genre findById(Integer id);

    List<Genre> findAll();

    Genre delete(Integer id);

    Genre update(Integer id, GenreDto entity);

    Genre add(GenreDto entity);
}

