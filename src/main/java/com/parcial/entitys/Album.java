package com.parcial.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;


@Entity
@Table(name="albums")
@Data
public class Album {
    @Id
    @Column(name="AlbumId")
    @GeneratedValue(generator = "Album_gen")
    @TableGenerator(name = "Album_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="albums",
            initialValue=1, allocationSize=1)
    private Integer albumId;

    @Column(name="Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Track> tracks;
}
