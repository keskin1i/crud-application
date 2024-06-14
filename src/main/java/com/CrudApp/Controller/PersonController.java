package com.CrudApp.Controller;

import com.CrudApp.Model.Person;
import com.CrudApp.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {


    // PersonService'nin otomatik olarak enjekte edilmesini sağlar.
    @Autowired
    private PersonService personService;

    // Tüm kişileri getirir.
    @GetMapping
    public List<Person> getAllPerson() {
        return personService.findAll();
    }

    // Belirli bir ID'ye sahip kişiyi getirir.
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Yeni bir kişi oluşturur.
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    // Belirli bir ID'ye sahip kişiyi günceller.
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Optional<Person> person = personService.findById(id);
        if (person.isPresent()) {
            Person existingPerson = person.get();
            existingPerson.setFirstName(updatedPerson.getFirstName());
            existingPerson.setLastName(updatedPerson.getLastName());
            existingPerson.setBirthDate(updatedPerson.getBirthDate());
            existingPerson.setGender(updatedPerson.getGender());
            existingPerson.setFavouriteTeam(updatedPerson.getFavouriteTeam());
            personService.save(existingPerson);
            return ResponseEntity.ok(existingPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Belirli bir ID'ye sahip kişiyi siler.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);
        if (person.isPresent()) {
            personService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
