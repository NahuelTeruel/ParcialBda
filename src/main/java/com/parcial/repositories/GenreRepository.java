package com.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.entitys.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
