package com.poc.api.service;

import com.poc.api.ApiApplication;
import com.poc.api.model.ApiModel;
import com.poc.api.repository.SearchRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class ApiService {

    @Autowired
    private SearchRepository apiRepository;

    public ApiService(SearchRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public List<ApiModel> findAll(){
        Iterable <ApiModel> results = apiRepository.findAll();
        List<ApiModel> resultList = new ArrayList<>();

        for(ApiModel model: results) {
            resultList.add(model);
        }
        return resultList;
    }

    public Optional<ApiModel> findById(Long id){

        return apiRepository.findById(id);
    }

    public Optional<ApiModel> findByZip(String zip){
        return apiRepository.findByZip(zip);
    }

    public ApiModel saveTest (ApiModel model){
        return apiRepository.save(model);
    }


}
