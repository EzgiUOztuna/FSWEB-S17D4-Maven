package com.workintech.sqlintro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Component
@Table(name = "ogrenci")
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ogrno;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String sinif;
    private int puan;
    @Column(nullable = true)
    private String dtarih;
}
