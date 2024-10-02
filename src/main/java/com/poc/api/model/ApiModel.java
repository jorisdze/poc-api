package com.poc.api.model;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name="YourEntityKind")
public class ApiModel {

    @Id
    private Long id ;
    private String numberOfYears;
    private String zip;




}
