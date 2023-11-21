package com.bda.ParcialBda.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "playlist")
@Data
public class Playlist {
    @Id
    @Column(name = "PlaylistId")
    @GeneratedValue(generator = "Playlists")
    @TableGenerator(name = "Playlists", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="playlists",
            initialValue = 1, allocationSize = 1)
    private Integer playlistId;

    @Column(name = "Name")
    private String name;

    /*@OneToMany(mappedBy = "playlist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PlaylistTrack> playlistTrack;*/
}
