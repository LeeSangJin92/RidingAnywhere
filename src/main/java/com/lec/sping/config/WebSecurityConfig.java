package com.lec.sping.config;

import com.lec.sping.jwt.JwtAccessDeniedHandler;
import com.lec.sping.jwt.JwtAuthenticationEntryPoint;
import com.lec.sping.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Component
public class WebSecurityConfig {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final TokenProvider tokenProvider;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic((basic)-> basic.disable());
        http.csrf((csrf) -> csrf.disable());
        http.cors(Customizer.withDefaults());
        http.sessionManagement((sessionManagement)->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.exceptionHandling((exceptionHandling)->exceptionHandling
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler));
        http.authorizeHttpRequests((authorizeRequests)->authorizeRequests
                .requestMatchers("/RA/Login").permitAll()
                .requestMatchers("/RA/Signup").permitAll()
                .requestMatchers("/RA/SignUp/Email").permitAll()
                .requestMatchers("/RA/BikeModel").permitAll()
                .requestMatchers("/RA/AddressData").permitAll()
                .requestMatchers("/RA/AddBike").permitAll()
                .requestMatchers("/Map/api/search").permitAll()
                .requestMatchers("/Map/api/coordinate").permitAll()
                .requestMatchers("/Map/api/address").permitAll()
                .requestMatchers("/RA/CheckRider").authenticated()
                .requestMatchers("/CR/CrewAllData").permitAll()
                .requestMatchers("/RA/LoadRiderBoard").permitAll()
                .requestMatchers("/RA/MyPage").authenticated()
                .requestMatchers("/RA/UpdateUser").authenticated()
                .requestMatchers("/RA/UpdateImage").authenticated()
                .requestMatchers("/RA/SelectBike").authenticated()
                .requestMatchers("/RA/DeleteBike").authenticated()
                .requestMatchers("/RA/BoardDetail/Board").permitAll()
                .requestMatchers("/RA/BoardDetail/CommentList").permitAll()
                .requestMatchers("/RA/BoardDetail/Comment").authenticated()
                .requestMatchers("/RA/BoardDetail/CommentReply").authenticated()
                .requestMatchers("/CR/Create").authenticated()
                .requestMatchers("/CR/LoadCrewData").authenticated()
                .requestMatchers("CR/ChangeAddress").authenticated()
                .requestMatchers("CR/ChangeContext").authenticated()
                .requestMatchers("CR/GetCrewMember").authenticated()
                .requestMatchers("CR/RequestCrewJoin").authenticated()
                .requestMatchers("CR/RequestJoinAccept").authenticated()
                .requestMatchers("CR/RequestWriteBoard").authenticated()
                .requestMatchers("CR/LoadCrewBoard").authenticated()
                .requestMatchers("CR/BoardDelete/Board").authenticated()
                .requestMatchers("CR/BoardChange/Board").authenticated()
                .requestMatchers("CR/BoardDetail/Board").authenticated()
                .requestMatchers("CR/BoardDetail/Comment").authenticated()
                .requestMatchers("CR/BoardDetail/TourAttend").authenticated()
                .requestMatchers("CR/BoardDetail/CommentReply").authenticated()
                .requestMatchers("CR/BoardDetail/CommentChange").authenticated()
                .requestMatchers("CR/BoardDetail/CommentDelete").authenticated()
                .anyRequest().authenticated());
        http.apply(new JwtSecurityConfig(tokenProvider));
        return http.build();
    }
}
