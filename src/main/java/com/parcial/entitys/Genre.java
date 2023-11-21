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
@Table(name="genres")
@Data
public class Genre {
    @Id
    @Column(name="GenreId")
    @GeneratedValue(generator = "Genre_gen")
    @TableGenerator(name = "Genre_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="genres",
            initialValue=1, allocationSize=1)
    private Integer genreId;
    
    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private List<Track> tracks;


}
