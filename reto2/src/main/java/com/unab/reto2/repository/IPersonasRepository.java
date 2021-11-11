package com.unab.reto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.reto2.entity.Personas;

public interface IPersonasRepository extends JpaRepository<Personas, Long> {

}
