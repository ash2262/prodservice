package dev.ashish.productservice.models;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@ManyToOne
private Category category;

@OneToOne
private  Price price;

}
