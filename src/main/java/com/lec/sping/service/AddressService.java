package com.lec.sping.service;

import com.lec.sping.domain.Address;
import com.lec.sping.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;
        public List<Address> getfindAll() {
            return addressRepository.findAll();
        }

        public Address findByLocation(String city, String town){
            return addressRepository.findByCityAndTown(city,town).orElseThrow(()->new NullPointerException("❌ 찾는 지역이 없습니다."));
        }
}
