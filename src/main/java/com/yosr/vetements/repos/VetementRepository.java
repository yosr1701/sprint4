package com.yosr.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yosr.vetements.entities.Vetement;

public interface VetementRepository extends JpaRepository<Vetement, Long> {

}
