package dev.ashish.productservice.inheritancedemo.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "userType",
     discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String name;
    private  String email;
}
