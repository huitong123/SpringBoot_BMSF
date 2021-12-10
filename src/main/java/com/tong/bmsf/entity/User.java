package com.tong.bmsf.entity;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class User {
    private String userName;
    private String passWord;
}
