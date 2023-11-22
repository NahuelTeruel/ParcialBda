package com.parcial.entitys.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDto {
    
    private String name;

    private Integer albumId;

    private Integer mediaTypeId;

    private Integer genreId;

    private String composer;

    private Integer milliseconds;

    private Integer bytes;

    private Double unitPrice;

}