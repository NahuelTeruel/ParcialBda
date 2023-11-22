/*package com.parcial1.Services;

import com.parcial.entitys.Artist;
import com.parcial.entitys.Dtos.ArtistDto;
import com.parcial.repositories.ArtistRepository;
import com.parcial.services.ArtistService;
import com.parcial.services.ArtistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistServiceImplTest {

    @InjectMocks
    private ArtistService artistService;

    @Mock
    private ArtistRepository artistRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Artist> artists = new ArrayList<>();
        // Agrega artistas ficticios a la lista
        // ...

        Mockito.when(artistRepository.findAll()).thenReturn(artists);

        List<Artist> result = artistService.findAll();

        assertNotNull(result);
        assertEquals(artists.size(), result.size());
    }

    @Test
    public void testGetById() {
        Integer artistId = 1;
        Artist artist = new Artist();
        artist.setId(artistId);

        Mockito.when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));

        Artist result = artistService.findById(artistId);

        assertNotNull(result);
        assertEquals(artist, result);
    }

    @Test
    public void testGetByIdNotFound() {
        Integer artistId = 1;

        Mockito.when(artistRepository.findById(artistId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            artistService.findById(artistId);
        });
    }

    private void assertThrows(Class<NoSuchElementException> noSuchElementExceptionClass, Object o) {
    }

    @Test
    public void testDelete() {
        Integer artistId = 1;
        Artist artist = new Artist();
        artist.setId(artistId);

        Mockito.when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));

        Artist deletedArtist = artistService.delete(artistId);

        assertNotNull(deletedArtist);
        assertEquals(artist, deletedArtist);
    }

    @Test
    public void testAdd() {
        ArtistDto artistDTO = new ArtistDto();
        artistDTO.setName("Nuevo Artista");

        Artist artist = new Artist();
        artist.setName(artistDTO.getName());

        Mockito.when(artistRepository.save(any(Artist.class))).thenReturn(artist);

        Artist result = artistService.add(artistDTO);

        assertNotNull(result);
        assertEquals(artist, result);
    }

    @Test
    public void testModify() {
        Integer artistId = 1;
        ArtistDto artistDTO = new ArtistDto();
        artistDTO.setName("Artista Modificado");

        Artist artist = new Artist();
        artist.setId(artistId);
        artist.setName(artistDTO.getName());

        Mockito.when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));
        Mockito.when(artistRepository.save(any(Artist.class))).thenReturn(artist);

        Artist result = artistService.modify(artistId, artistDTO);

        assertNotNull(result);
        assertEquals(artist, result);
    }

    @Test
    public void testModifyNotFound() {
        Integer artistId = 1;
        ArtistDto artistDTO = new ArtistDto();
        artistDTO.setName("Artista Modificado");

        Mockito.when(artistRepository.findById(artistId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            artistService.modify(artistId, artistDTO);
        });
    }
}*/