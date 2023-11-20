package com.bda.ParcialBda.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "artists")
@Data
public class Artist {
    @Id
    @Column(name = "ArtistId")
    @GeneratedValue(generator = "Artists")
    @TableGenerator(name = "Artists", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="artists",
            initialValue=1, allocationSize=1)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Album> albums;
}
