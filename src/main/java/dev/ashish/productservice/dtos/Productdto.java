package dev.ashish.productservice.dtos;

import dev.ashish.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class Productdto {
    private Long id;
    private String title;
    private String description;
    private String image;

    private Price price;
}
