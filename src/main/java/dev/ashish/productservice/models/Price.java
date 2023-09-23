package dev.ashish.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Price extends  BaseModel {
    String currency;
    double price;
}
