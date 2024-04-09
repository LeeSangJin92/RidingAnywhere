package com.lec.sping.service;

import com.lec.sping.domain.Address;
import com.lec.sping.domain.User;
import com.lec.sping.domain.crew.Crew;
import com.lec.sping.domain.crew.CrewManager;
import com.lec.sping.dto.CreateCrewDto;
import com.lec.sping.repository.AddressRepository;
import com.lec.sping.repository.CrewManagerRepository;
import com.lec.sping.repository.CrewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CrewService {

    private final CrewRepository crewRepository;
    private final AddressRepository addressRepository;
    private final CrewManagerRepository crewManagerRepository;

    public Crew createCrew(User crewMaster, CreateCrewDto crewDto){
        Address address = addressRepository.findByCityAndTown(crewDto.getCrew_city(), crewDto.getCrew_town()).orElseThrow(()->new RuntimeException("❌존재 하지 않는 지역입니다."));
        Crew newCrew = new Crew();
        newCrew.setCrew_name(crewDto.getCrew_name());
        newCrew.setCrew_location(address);
        newCrew.setCrew_context(crewDto.getCrew_context());
        newCrew.setUser(crewMaster);
        return crewRepository.save(newCrew);
    }

    public void defaultCrewManager(Crew crew){
        CrewManager crewManager = new CrewManager();
        crewManager.setCrew(crew);
        crewManager.setUser(crew.getUser());
        crewManagerRepository.save(crewManager);
        System.out.println("✅크루 초기화 완료");
    }

    public Crew findById(Long crewId) {
        System.out.println("테스트"+crewRepository.findById(crewId).orElseThrow(()->new NullPointerException("❌존재 하지 않은 크루입니다.")));
        return crewRepository.findById(crewId).orElseThrow(()->new NullPointerException("❌존재 하지 않은 크루입니다."));
    }
}