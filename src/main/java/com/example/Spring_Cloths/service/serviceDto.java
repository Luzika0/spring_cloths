package com.example.Spring_Cloths.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Spring_Cloths.Mapping.Mapper;
import com.example.Spring_Cloths.dto.productDTO.dtoRequest;
import com.example.Spring_Cloths.dto.productDTO.dtoResponse;
import com.example.Spring_Cloths.models.productModels;
import com.example.Spring_Cloths.repository.serviceRepository;
@Service
public class serviceDto {
    private final serviceRepository  repository;
    public serviceDto(serviceRepository repository) {
        this.repository = repository;
    }
    public dtoResponse create(dtoRequest dtoRequest)throws IOException{
        productModels productModels = Mapper.ToEntity(dtoRequest);
        MultipartFile file = dtoRequest.getImage();
        if(!file.isEmpty()){
            if (file != null && !file.isEmpty()) {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get("Uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Files.copy(file.getInputStream(), uploadPath.resolve(fileName));
        productModels.setImage(fileName);
    }
        }
        repository.save(productModels);
        return Mapper.Response(productModels);
    }
    public List<dtoResponse> getAll(){
        List<productModels> productModels = repository.findAll();
        return productModels.stream().map(Mapper::Response).toList();
    }
    public dtoResponse delete(long id){
        
        productModels productModels = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        if (productModels.getImage() != null) {

        Path imagePath = Paths.get("uploads").resolve(productModels.getImage());

        try {
            System.out.println("Deleting: " + imagePath.toAbsolutePath());
            Files.deleteIfExists(imagePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image", e);
        }
    }
        repository.delete(productModels);
        return Mapper.Response(productModels);
    }
    public dtoResponse update(Long id,dtoRequest dto) throws IOException{
        productModels productModels = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        Mapper.updateEntityFromDto(productModels, dto);
        MultipartFile file=dto.getImage();
        if (file != null && !file.isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path uploadPath = Paths.get("Uploads");
            if (productModels.getImage() != null) {
                    Path oldImagePath = Paths.get("uploads").resolve(productModels.getImage());
                    Files.deleteIfExists(oldImagePath);
                }
            if (!Files.exists(uploadPath)) {
               
                Files.createDirectories(uploadPath);
            }
            Files.copy(file.getInputStream(), uploadPath.resolve(fileName));
            productModels.setImage(fileName);
        }
        repository.save(productModels);
        return Mapper.Response(productModels);
    }
    public dtoResponse getById(Long id){
        productModels productModels = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        return Mapper.Response(productModels);
    }
}
