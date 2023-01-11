package com.example.maersk.repo;


import java.util.UUID;

import  org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.maersk.domain.Bookings;
public interface BookingsRepo extends ReactiveCassandraRepository<Bookings,Integer> {

}
