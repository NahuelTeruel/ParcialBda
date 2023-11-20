package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Genre;
import com.bda.ParcialBda.entities.dto.GenreDto;
import com.bda.ParcialBda.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getById(Integer id) {
        return genreRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre add(GenreDto entity) {
        Genre genre = new Genre();
        if(entity.getName() == null){
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
        else{
            genre.setName(entity.getName());
            return genreRepository.save(genre);
        }
    }

    @Override
    public Genre delete(Integer id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
        return genre;
    }

    @Override
    public Genre modify(Integer id, GenreDto entity) {
        Optional<Genre> genre = Optional.of(genreRepository.findById(id).orElseThrow());
        if(genre.isPresent()){
            genre.get().setName(entity.getName());
            return genreRepository.save(genre.get());
        }
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
