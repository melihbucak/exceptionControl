package com.project.mergentech.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Filtre {
    private String hastaneAdi;
    private String kullaniciKodu;
    private LocalDateTime ilkTarih;
    private LocalDateTime sonTarih;
}

