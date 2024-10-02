package com.poc.api.controller;


import com.poc.api.model.ApiModel;
import com.poc.api.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/search")
public class ApiController {

    private ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/{id}")
    public Optional<ApiModel> getPersonById(@PathVariable Long id) {
        return apiService.findById(id);
    }

    @GetMapping("/all")
    public List<ApiModel> getAll(){
        return apiService.findAll();
    }

    @GetMapping("/zip/{zip}")
    public Optional<ApiModel> getByName(@PathVariable String zip){
        return apiService.findByZip(zip);
    }

    @PostMapping("/model")
    public ResponseEntity createRow(@RequestBody ApiModel model){
        try{
            apiService.saveTest(model);
            return  ResponseEntity.ok("1 row has been inserted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during export: " + e.getMessage());
        }


    }

}
