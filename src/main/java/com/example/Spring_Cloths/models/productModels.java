package com.example.Spring_Cloths.models;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cloths")
public class productModels {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false,length = 500)
    private String description;
    @Column(nullable = false)
    private String image;
}
