package com.keven.testejavajr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keven.testejavajr.domain.Contatos;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Integer>{

}
