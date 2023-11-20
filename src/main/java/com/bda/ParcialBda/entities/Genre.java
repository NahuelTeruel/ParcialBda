package com.bda.ParcialBda.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="genres")
@Data
public class Genre {
    @Id
    @Column(name="GenreId")
    @GeneratedValue(generator = "GENRES")
    @TableGenerator(name = "GENRES", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="genres",
            initialValue=1, allocationSize=1)
    private Integer genreId;

    @Column(name="Name")
    private String name;
}
