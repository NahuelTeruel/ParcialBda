package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Track;
import com.parcial.entitys.Dtos.TrackDto;

public interface TrackService {

    Track findById(Integer id);

    List<Track> findAll();

    Track delete(Integer id);

    Track update(Integer id, TrackDto entity);

    Track add(TrackDto entity);
}

