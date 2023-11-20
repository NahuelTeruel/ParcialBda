package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Item;
import com.bda.ParcialBda.entities.dto.ItemDto;
import com.bda.ParcialBda.repositories.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    public ItemServiceImpl(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item delete(Integer id) {
        Item item = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(item);
        return item;
    }

    @Override
    public Item modify(Integer id, ItemDto entity) {
        Optional<Item> item = Optional.of(itemRepository.findById(id).orElseThrow());
        Optional<Invoce> invoice = Optional.of(itemService.getById((int) entity.getInvoiceId()));
        Optional<Track> track = Optional.of(itemService.getById((int) entity.getTrackId()));

        if(item.isPresent() && invoice.isPresent() && track.isPresent()){
            item.get().setIdItem(entity.getIdItem());
            item.get().setInvoceId(invoice.get());
            return itemRepository.save(item.get());
        }
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }

    @Override
    public Item add(ItemDto entity) {
        Item item = new Item();
        Optional<Invoice> invoice = Optional.of(InvoiceService.getById((int) entity.getInvoiceId()));
        Optional<Track> track = Optional.off(TrackService.getById((int) entity.getTrackId()));
        if (Invoice.isPresent() && Track.isPresent()){
            item.setInvoiceId(entity.getInvoiceId());
            item.setTrack(entity.getTrackId());
            item.setUnitPrice(entity.getUnitPrice());
            item.setQuantity(entity.getQuantity());
            return itemRepository.save(item);
        }
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
