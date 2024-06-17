package com.CrudApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.*;
import java.time.LocalDate;

// @Entity anotasyonu, bu sınıfın bir JPA varlığı olduğunu belirtir.
@Entity
public class Kisi {

    // @Id ve @GeneratedValue anotasyonları, bu alanın birincil anahtar olduğunu ve otomatik olarak oluşturulacağını belirtir.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isim;
    private String soyisim;
    private LocalDate dogumTarihi;
    private String cinsiyet;
    private String tuttuguTakim;

    // Getters ve Setters yöntemleri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public LocalDate getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(LocalDate dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getTuttuguTakim() {
        return tuttuguTakim;
    }

    public void setTuttuguTakim(String tuttuguTakim) {
        this.tuttuguTakim = tuttuguTakim;
    }
}

