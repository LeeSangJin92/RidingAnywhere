package com.lec.sping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.sping.domain.crew.Crew;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String city;
    private String town;

    //FK 영역
    @JsonIgnore
    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    private List<User> user;

    @JsonIgnore
    @OneToMany(mappedBy = "crew_location")
    @ToString.Exclude
    private List<Crew> crew;

}
