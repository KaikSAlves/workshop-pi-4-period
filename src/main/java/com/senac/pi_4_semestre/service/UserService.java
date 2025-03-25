package com.senac.pi_4_semestre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.pi_4_semestre.model.User;
import com.senac.pi_4_semestre.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository r;

    //create
    public User save(User user){
        return r.save(user);
    }

    //read 
    public List<User> findAll(){
        return r.findAll();
    }

    public User findById(Integer id){
        return r.findById(id).orElse(null);
    }

    //update
    public User update(Integer id, User u2){
        Optional<User> u1 = r.findById(id);

        if(u1.isPresent()){
            updateData(u1.get(), u2);
        }

        return r.save(u1.get());
    }

    private void updateData(User u1, User u2){
        u1.setEmail(u2.getEmail());
        u1.setName(u2.getName());
        u1.setPassword(u2.getPassword());
        u1.setPhone(u2.getPhone());

    }

    //delete

    public void delete(Integer id){
        User u = r.findById(id).orElse(null);
        r.delete(u);
    }
}
