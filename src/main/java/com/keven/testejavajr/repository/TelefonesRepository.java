package com.keven.testejavajr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keven.testejavajr.domain.Telefones;

@Repository
public interface TelefonesRepository extends JpaRepository<Telefones, Integer>{

}
