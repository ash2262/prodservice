package dev.ashish.productservice.inheritancedemo.mappesuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentor extends  User{
    private  double averageRating;
}
