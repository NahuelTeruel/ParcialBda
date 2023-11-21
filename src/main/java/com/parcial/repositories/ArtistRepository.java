package com.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.entitys.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}

