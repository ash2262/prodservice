package dev.ashish.productservice.models;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product extends  BaseModel{
private String title;
private  String description;
private  String image;
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name="category")
private Category category;

@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
private  Price price;

}
