package com.lec.sping.domain.bike;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.sping.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class BikeGarage {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long bikegarage_id;          // 내 바이크 Id
    private String bike_year;           // 바이크 연식
    private Boolean bike_select;        // 대표 바이크

    // FK 영역
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;                  // 유저

    @ManyToOne(optional = false)
    @JoinColumn(name = "bikemodel_id")
    private BikeModel bikeModel;       // 바이크 모델
}
