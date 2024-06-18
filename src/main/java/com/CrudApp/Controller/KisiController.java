package com.CrudApp.Controller;


import com.CrudApp.Model.Kisi;
import com.CrudApp.Service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @RestController anotasyonu, bu sınıfın bir RESTful web servis denetleyicisi olduğunu belirtir.
@RestController
@RequestMapping("/api/kisiler")
@CrossOrigin(origins = "http://localhost:3000")
public class KisiController {


    @Autowired
    private KisiService kisiService;


    @GetMapping
    public List<Kisi> getAllKisiler() {
        return kisiService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Kisi> getKisiById(@PathVariable Long id) {
        Optional<Kisi> kisi = kisiService.findById(id);
        if (kisi.isPresent()) {
            return ResponseEntity.ok(kisi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Kisi createKisi(@RequestBody Kisi kisi) {
        return kisiService.save(kisi);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Kisi> updateKisi(@PathVariable Long id, @RequestBody Kisi updatedKisi) {
        Optional<Kisi> kisi = kisiService.findById(id);
        if (kisi.isPresent()) {
            Kisi existingKisi = kisi.get();
            existingKisi.setIsim(updatedKisi.getIsim());
            existingKisi.setSoyisim(updatedKisi.getSoyisim());
            existingKisi.setDogumTarihi(updatedKisi.getDogumTarihi());
            existingKisi.setCinsiyet(updatedKisi.getCinsiyet());
            existingKisi.setTuttuguTakim(updatedKisi.getTuttuguTakim());
            kisiService.save(existingKisi);
            return ResponseEntity.ok(existingKisi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKisi(@PathVariable Long id) {
        Optional<Kisi> kisi = kisiService.findById(id);
        if (kisi.isPresent()) {
            kisiService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

