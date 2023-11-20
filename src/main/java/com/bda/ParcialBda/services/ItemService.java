package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Artist;
import com.bda.ParcialBda.entities.Item;
import com.bda.ParcialBda.entities.dto.ArtistDto;
import com.bda.ParcialBda.entities.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item getById(Integer itemId);

    Item delete(Integer itemId);

    Item add(ItemDto entity);

    Item modify(Integer id, ItemDto entity);
}
