package com.parcial1.Services;

import com.parcial.entitys.Album;
import com.parcial.entitys.Artist;
import com.parcial.entitys.Dtos.AlbumDto;
import com.parcial.repositories.AlbumRepository;
import com.parcial.services.AlbumServiceImpl;
import com.parcial.services.ArtistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl albumService;

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private ArtistService artistService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById() {
        Integer albumId = 1;
        Album album = new Album();
        album.setAlbumId(albumId);

        Mockito.when(albumRepository.findById(albumId)).thenReturn(Optional.of(album));

        Album result = albumService.findById(albumId);

        assertNotNull(result);
        assertEquals(album, result);
    }

    @Test
    public void testGetByIdNotFound() {
        Integer albumId = 1;

        Mockito.when(albumRepository.findById(albumId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            albumService.findById(albumId);
        });
    }

    @Test
    public void testDelete() {
        Integer albumId = 1;
        Album album = new Album();
        album.setAlbumId(albumId);

        Mockito.when(albumRepository.findById(albumId)).thenReturn(Optional.of(album));

        Album deletedAlbum = albumService.delete(albumId);

        assertNotNull(deletedAlbum);
        assertEquals(album, deletedAlbum);
    }

    @Test
    public void testModify() {
        Integer albumId = 1;
        AlbumDto albumDTO = new AlbumDto();
        albumDTO.setTitle("Álbum Modificado");
        albumDTO.setArtistId(1); // Supongamos que 1 es el ID de un artista existente

        Album album = new Album();
        album.setAlbumId(albumId);
        album.setTitle(albumDTO.getTitle());

        Artist artist = new Artist();
        artist.setId(albumDTO.getArtistId());

        Mockito.when(albumRepository.findById(albumId)).thenReturn(Optional.of(album));
        Mockito.when(artistService.findById(albumDTO.getArtistId())).thenReturn(artist);
        Mockito.when(albumRepository.save(any(Album.class))).thenReturn(album);

        Album result = albumService.update(albumId, albumDTO);

        assertNotNull(result);
        assertEquals(album, result);
        assertEquals(artist, result.getArtist());
    }

    @Test
    public void testModifyNotFound() {
        Integer albumId = 1;
        AlbumDto albumDTO = new AlbumDto();
        albumDTO.setTitle("Álbum Modificado");
        albumDTO.setArtistId(1);

        Mockito.when(albumRepository.findById(albumId)).thenReturn(Optional.empty());


        assertThrows(NoSuchElementException.class, () -> {
            albumService.update(albumId, albumDTO);
        });

    }

    @Test
    public void testAdd() {
        AlbumDto albumDTO = new AlbumDto();
        albumDTO.setTitle("Nuevo Álbum");
        albumDTO.setArtistId(1);

        Album album = new Album();
        album.setTitle(albumDTO.getTitle());

        Artist artist = new Artist();
        artist.setId(albumDTO.getArtistId());
        album.setArtist(artist);
        Mockito.when(artistService.findById(albumDTO.getArtistId())).thenReturn(artist);
        Mockito.when(albumRepository.save(any(Album.class))).thenReturn(album);

        Album result = albumService.add(albumDTO);

        assertNotNull(result);
        assertEquals(album, result);
        assertEquals(artist, result.getArtist());
    }
}
