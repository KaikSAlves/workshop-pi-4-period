package com.senac.pi_4_semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.pi_4_semestre.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
}
