package com.CrudApp.Repository;


import com.CrudApp.Model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

// KisiRepository arayüzü, Kisi nesneleri için CRUD işlemlerini sağlar.
public interface KisiRepository extends JpaRepository<Kisi, Long> {
}

