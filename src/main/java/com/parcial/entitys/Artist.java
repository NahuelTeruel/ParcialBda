package com.parcial.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Entity
@Table(name="artists")
@Data
public class Artist {
    @Id
    @Column(name = "ArtistId")
    @GeneratedValue(generator = "Artists_gen")
    @TableGenerator(name = "Artists_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="artists",
            initialValue=1, allocationSize=1)
    private Integer id;

    @Column(name= "Name")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<Album> albums;
}
