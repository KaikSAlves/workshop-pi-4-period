package com.senac.pi_4_semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.pi_4_semestre.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
}
