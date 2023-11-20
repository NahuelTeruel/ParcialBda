package com.bda.ParcialBda.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import javax.sound.midi.Track;
import java.util.List;

@Entity
@Table(name="albums")
@Data
public class Album {
    @Id
    @Column(name="AlbumId")
    @GeneratedValue(generator = "ALBUMS")
    @TableGenerator(name = "ALBUMS", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="albums",
            initialValue=1, allocationSize=1)
    private Integer albumId;

    @Column(name="Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    @JsonBackReference
    private Artist artist;

    /*@OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Track> tracks;*/
}
