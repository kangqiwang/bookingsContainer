package com.example.maersk.repo;

import com.example.maersk.domain.Container;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface ContainerRepo extends ReactiveCassandraRepository<Container,Integer> {

    @AllowFiltering
    Mono<Container> findByContainerSizeAndContainerType(int size, String type);
    

    // @AllowFiltering
	// public Optional<Container> findByContainerTypeAndContainerSize(Integer containerSize,String containerType);
}
