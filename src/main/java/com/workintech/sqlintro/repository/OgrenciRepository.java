package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    //Öğrenci tablosundaki tüm kayıtları listeleyin.
    String QUESTION_1 = "SELECT * FROM ogrenci";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    //Öğrenci tablosundaki kız öğrencileri listeleyin.
    String QUESTION_2 = "SELECT * FROM ogrenci WHERE cinsiyet='K'";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    //Öğrenci tablosunda kaydı bulunan sınıfların adını her sınıf bir kez görüntülenecek şekilde listeleyiniz
    String QUESTION_3 = "SELECT DISTINCT sinif FROM ogrenci";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    //Öğrenci tablosunda, 10A sınıfında olan kız öğrencileri listeleyiniz.
    String QUESTION_4 = "SELECT * FROM ogrenci WHERE cinsiyet='K' AND sinif='10A'";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    //Öğrenci numarası 5 ile 10 arasında olan Kız öğrencileri listeleyiniz.
    String QUESTION_5 = "SELECT * FROM ogrenci WHERE cinsiyet='K' AND ogrno >5 AND ogrno <10";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // Öğrencileri adına göre sıralayınız (alfabetik)
    String QUESTION_6 = "SELECT * FROM ogrenci ORDER BY ad";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // 10A sınıfındaki öğrencileri okul numarasına göre azalan olarak sıralayınız.
    String QUESTION_7 = "SELECT * FROM ogrenci WHERE sinif='10A' ORDER BY ogrno";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    //Öğrenciler tablosundaki en genç öğrenciyi listeleyiniz.
    String QUESTION_8 = "SELECT * FROM ogrenci ORDER BY dtarih DESC LIMIT 1";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    //Öğrenciler tablosundaki en yaşlı öğrenciyi listeleyiniz.
    String QUESTION_9 = "SELECT * FROM ogrenci ORDER BY dtarih ASC LIMIT 1";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    //İkinci harfi E olan ogrencileri listeleyiniz.
    String QUESTION_10 = "SELECT * FROM ogrenci WHERE ad ILIKE '_E%'";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();

}
