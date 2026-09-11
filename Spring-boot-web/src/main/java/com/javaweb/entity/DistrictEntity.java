package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "district")
@Getter
@Setter
public class DistrictEntity extends  BaseEntity {
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
