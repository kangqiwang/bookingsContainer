package com.example.maersk.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
@Data
@Getter
@Setter
public class Bookings {

    @PrimaryKey
    private UUID id;

    private int containerSize;

    private ContainerType containerType;

    private String origin;

    private String destination;

    private int quantity;

    private Date timeStamp;

}
