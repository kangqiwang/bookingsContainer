package com.example.maersk.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("container")
@Setter
@Getter
public class Container {
    @PrimaryKey
    private int containerId;

    @Column(value = "container_type")
    private String containerType;

    @Column(value = "container_size")
    private int containerSize;

    @Column(value = "quantity")
    private int quantity;

    @Column(value = "yard")
    private String yard;


}
