package com.parcial.entitys.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlbumDto {
    
    private String title;

    private Integer artistId;

}
