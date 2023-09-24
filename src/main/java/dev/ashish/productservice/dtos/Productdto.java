package dev.ashish.productservice.dtos;

import dev.ashish.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Productdto {
    private String title;
    private String description;
    private String image;

    private Price price;
}
