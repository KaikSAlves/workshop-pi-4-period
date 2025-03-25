package com.senac.pi_4_semestre.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pi_4_semestre.model.User;
import com.senac.pi_4_semestre.service.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/user")
public class UserResource {
    
    @Autowired
    private UserService service;

    //GET'S

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User user = service.findById(id);
        HttpStatus status = HttpStatus.OK;

        if(user == null){
            status = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(status).body(user);
    }

    //POST

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User u = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }
    
    //PUT

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
        User u = service.update(id, user);
        return ResponseEntity.ok().body(u);
    }
    
    //DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
