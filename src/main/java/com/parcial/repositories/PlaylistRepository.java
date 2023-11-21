package com.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.entitys.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}

