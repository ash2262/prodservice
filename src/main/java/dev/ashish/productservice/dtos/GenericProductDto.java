package dev.ashish.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDto {
    private long id;
    private String title;
    private  String description;
    private  String image;
    private String category;
    private  double price;
}
