package com.example.maersk.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table("bookings")
@Data
@Getter
@Setter
public class Bookings {

    @PrimaryKey(value = "booking_ref_id")
    private int bookingRefId = 957000001;

    @Column(value = "container_size")
    private int containerSize;

    @Column(value = "container_type")
    private String containerType;

    @Column(value = "origin")
    private String origin;

    @Column(value = "destination")
    private String destination;

    @Column(value = "quantity")
    private int quantity;

    @Column(value = "time_stamp")
    private Timestamp timeStamp;


}
