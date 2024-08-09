package com.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseModel {
    private String name;
    private String description;

    //commented
//    @JsonBackReference
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;
}
