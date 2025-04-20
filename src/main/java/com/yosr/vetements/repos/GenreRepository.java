package com.yosr.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yosr.vetements.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
