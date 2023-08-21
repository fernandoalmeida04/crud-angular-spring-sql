package com.testebackend.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testebackend.springboot.model.Projeto;

@Repository
public interface ProjetosRepository extends JpaRepository<Projeto, Long>{

}
