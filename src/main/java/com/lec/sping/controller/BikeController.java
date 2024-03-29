package com.lec.sping.controller;

import com.lec.sping.dto.BikeAddDataDto;
import com.lec.sping.dto.BikeAllDataDto;
import com.lec.sping.jwt.TokenProvider;
import com.lec.sping.service.BikeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/RA")
public class BikeController {
    private final BikeService bikeService;
    private final TokenProvider tokenProvider;

    @CrossOrigin
    @GetMapping("/BikeModel")
    public ResponseEntity<BikeAllDataDto> getBikeModel(){
        System.out.println("바이크 모델 조회 시작...");
        BikeAllDataDto bikeModelList = bikeService.getfindAll();
        System.out.println("바이크 모델 전달 완료!");
        return new ResponseEntity<>(bikeModelList, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/AddBike")
    public ResponseEntity<?> addBikeData(@RequestBody BikeAddDataDto bikeAddDataDto, @RequestHeader("Authorization") String authTokenHeader){

        String token = authTokenHeader.substring(7);
        bikeAddDataDto.setUserEmail(tokenProvider.parseClaims(token).getSubject());
        System.out.println("🛜바이크 데이터 추가 시작...");
        bikeService.addBikeData(bikeAddDataDto);
        System.out.println("✅바이크 데이터 추가 완료");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
