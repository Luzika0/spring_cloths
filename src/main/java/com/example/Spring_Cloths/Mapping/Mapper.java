package com.example.Spring_Cloths.Mapping;

import com.example.Spring_Cloths.dto.productDTO.dtoRequest;
import com.example.Spring_Cloths.dto.productDTO.dtoResponse;
import com.example.Spring_Cloths.models.productModels;

public class Mapper {
    public static dtoResponse Response(productModels productModels){
    dtoResponse dtoResponse = new dtoResponse();
    dtoResponse.setName(productModels.getName());
    dtoResponse.setPrice(productModels.getPrice());
    dtoResponse.setCategory(productModels.getCategory());
    dtoResponse.setDescription(productModels.getDescription());
    dtoResponse.setImage("localhost:4000/Uploads/"+productModels.getImage());
    return dtoResponse;
}
    public static productModels ToEntity(dtoRequest dtoRequest){
        productModels productModels = new productModels();
        productModels.setName(dtoRequest.getName());
        productModels.setPrice(dtoRequest.getPrice());
        productModels.setCategory(dtoRequest.getCategory());
        productModels.setDescription(dtoRequest.getDescription());
        productModels.setImage(dtoRequest.getImage().getOriginalFilename());
        return productModels;
    }
    public static void updateEntityFromDto(productModels productModels, dtoRequest dtoRequest) {
        productModels.setName(dtoRequest.getName());
        productModels.setPrice(dtoRequest.getPrice());
        productModels.setCategory(dtoRequest.getCategory());
        productModels.setDescription(dtoRequest.getDescription());
    }
    
}
