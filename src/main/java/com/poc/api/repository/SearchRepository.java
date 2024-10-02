package com.poc.api.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import com.poc.api.model.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SearchRepository extends DatastoreRepository<ApiModel,Long> {
    Optional<ApiModel> findByZip(String zip);
}
