package dev.ashish.productservice.inheritancedemo.mappesuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_student")
public class Student  extends  User{
    private  double psp;
    private  double attendance;
}
