package com.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.entitys.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}

