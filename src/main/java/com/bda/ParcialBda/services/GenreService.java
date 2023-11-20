package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Genre;
import com.bda.ParcialBda.entities.dto.GenreDto;

import java.util.List;

public interface GenreService {
    Genre getById(Integer id);
    List<Genre> findAll();
    Genre add(GenreDto entity);
    Genre delete(Integer id);
    Genre modify(Integer id, GenreDto entity);
}
