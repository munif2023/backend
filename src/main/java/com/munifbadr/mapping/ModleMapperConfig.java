package com.munifbadr.mapping;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModleMapperConfig {
@Bean
    public ModelMapper modleMapper(){
        ModelMapper mapper=new ModelMapper();
        return mapper;

    }



}
