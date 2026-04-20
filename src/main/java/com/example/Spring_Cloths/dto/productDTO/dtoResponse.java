package com.example.Spring_Cloths.dto.productDTO;




import lombok.Data;

@Data
public class dtoResponse {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;
    private String image; 
    
}
