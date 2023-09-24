package dev.ashish.productservice.models;


import jakarta.persistence.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel{
    @Column
    private  String name;

@OneToMany(mappedBy = "category")
@Fetch(FetchMode.SELECT)
private List<Product>products=new ArrayList<>();


}
