package com.parcial.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tracks")
@Data
public class Track {
    @Id
    @Column(name="TrackId")
    @GeneratedValue(generator = "Track_gen")
    @TableGenerator(name = "Track_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="tracks",
            initialValue=1, allocationSize=1)
    private Integer trackId;

    @Column(name="Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album album;

    @Column(name="MediatypeId")
    private Integer mediaTypeId;

    @ManyToOne
    @JoinColumn(name="GenreId")
    private Genre genre;

    @Column(name="Composer")
    private String composer;

    @Column(name="Milliseconds")
    private Integer milliseconds;

    @Column(name="Bytes")
    private Integer bytes;

    @Column(name="Unitprice")
    private Double unitPrice;

    @ManyToMany(mappedBy = "tracks")
    @JsonIgnore
    private List<Playlist> playlists;

    @OneToMany(mappedBy = "trackId")
    @JsonIgnore
    private List<InvoiceItem> invoiceItems;
}
