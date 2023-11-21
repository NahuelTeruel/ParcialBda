package com.parcial.entitys;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Entity
@Table(name = "playlists")
@Data
public class Playlist {
    @Id
    @Column(name = "PlaylistId")
    @GeneratedValue(generator = "Playlist_gen")
    @TableGenerator(name = "Playlist_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="playlists",
            initialValue=1, allocationSize=1)
    private Integer playlistId;

    @Column(name = "Name")
    private String name;

    @ManyToMany
    @JoinTable(name= "Playlist_Track",joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "TrackId"))
    @JsonIgnore
    private List<Track> tracks =new ArrayList<>();

}
