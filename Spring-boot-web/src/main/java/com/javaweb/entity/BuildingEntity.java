package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
@Getter
@Setter
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @Column(name = "floorarea")
    private Double floorArea;

    @Column(name = "rentprice")
    private Double rentPrice;

    @Column(name = "type")
    private String type;

    @Column(name = "rentpricedescription")
    private String rpDescription;

    @Column(name = "managername")
    private String managerName;

    @Column(name = "managerphone")
    private String managerPhone;

    private String structure;
    private String direction;
    private String level;
    private String image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buildingEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();

    @OneToMany(mappedBy = "building", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<>();

}
