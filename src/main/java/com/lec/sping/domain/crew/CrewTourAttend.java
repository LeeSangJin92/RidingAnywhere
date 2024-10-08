package com.lec.sping.domain.crew;

import com.lec.sping.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "crew_tour_attend")
public class CrewTourAttend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                // 모임 Id
    private Long tourMaxCnt;        // 제한인원

    @OneToOne
    CrewBoard tourBoard;            // 모임 게시글

    @OneToMany
    List<User> attendMember;        // 참여 인원
}
