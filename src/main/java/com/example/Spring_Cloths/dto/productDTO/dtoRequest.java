package com.example.Spring_Cloths.dto.productDTO;


import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class dtoRequest {
    private String name;
    private Double price;
    private String category;
    private String description;
    private MultipartFile image;
}
