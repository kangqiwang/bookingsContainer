package com.example.maersk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.maersk.domain.Container;
import com.example.maersk.repo.ContainerRepo;

import reactor.core.publisher.Mono;

@Service
public class ContainerService {
    
    @Autowired
    private ContainerRepo containerRepo;


    public Mono<Container> findById(int id){
        return containerRepo.findById(id);
    }

    /**
     * 
     * @param size
     * @param type
     * @param yard
     * @return
     */
    public Mono<Container> findByContainerSizeAndContainerType(int size, String type){
        return containerRepo.findByContainerSizeAndContainerType(size, type);
    }

    
}
