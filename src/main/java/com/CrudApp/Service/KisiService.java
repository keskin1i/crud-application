package com.CrudApp.Service;


import com.CrudApp.Model.Kisi;
import com.CrudApp.Repository.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service anotasyonu, bu sınıfın bir servis bileşeni olduğunu belirtir.
@Service
public class KisiService {

    // KisiRepository'nin otomatik olarak enjekte edilmesini sağlar.
    @Autowired
    private KisiRepository kisiRepository;

    // Tüm kişileri getirir.
    public List<Kisi> findAll() {
        return kisiRepository.findAll();
    }

    // Belirli bir ID'ye sahip kişiyi getirir.
    public Optional<Kisi> findById(Long id) {
        return kisiRepository.findById(id);
    }

    // Yeni bir kişi kaydeder veya mevcut bir kişiyi günceller.
    public Kisi save(Kisi kisi) {
        return kisiRepository.save(kisi);
    }

    // Belirli bir ID'ye sahip kişiyi siler.
    public void deleteById(Long id) {
        kisiRepository.deleteById(id);
    }
}
