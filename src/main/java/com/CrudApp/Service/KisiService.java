package com.CrudApp.Service;


import com.CrudApp.Model.Kisi;
import com.CrudApp.Repository.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class KisiService {


    @Autowired
    private KisiRepository kisiRepository;


    public List<Kisi> findAll() {
        return kisiRepository.findAll();
    }


    public Optional<Kisi> findById(Long id) {
        return kisiRepository.findById(id);
    }


    public Kisi save(Kisi kisi) {
        return kisiRepository.save(kisi);
    }


    public void deleteById(Long id) {
        kisiRepository.deleteById(id);
    }
}
