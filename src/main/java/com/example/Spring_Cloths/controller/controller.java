package com.example.Spring_Cloths.controller;
import java.io.IOException;
import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Spring_Cloths.dto.productDTO.dtoRequest;
import com.example.Spring_Cloths.dto.productDTO.dtoResponse;
import com.example.Spring_Cloths.service.serviceDto;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class controller {
    private final serviceDto serviceDto;
    public  controller(serviceDto serviceDto){
        this.serviceDto = serviceDto;
    }
   @PostMapping(value="/create", consumes = "multipart/form-data")
    public dtoResponse create(@ParameterObject @ModelAttribute dtoRequest dtoRequest,@RequestPart MultipartFile image) throws IOException {
        dtoRequest.setImage(image);
        return serviceDto.create(dtoRequest);
    }
    @GetMapping("/getAll")
    public List<dtoResponse> getAll(){
        return serviceDto.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public dtoResponse delete(@PathVariable long id){
        return serviceDto.delete(id);
    }
    @PutMapping(value="/update/{id}", consumes = "multipart/form-data")
    public dtoResponse update(@PathVariable long id,@ParameterObject @ModelAttribute dtoRequest dtoRequest,@RequestPart MultipartFile image) throws IOException{
        dtoRequest.setImage(image);
        return serviceDto.update(id, dtoRequest);
    }
    @GetMapping("/getById/{id}")
    public dtoResponse getById(@PathVariable long id){
        return serviceDto.getById(id);
    }
}
