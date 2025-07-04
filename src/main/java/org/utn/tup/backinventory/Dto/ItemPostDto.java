package org.utn.tup.backinventory.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPostDto {
    private String name;
    private String description;
    private Integer quantity;
}
