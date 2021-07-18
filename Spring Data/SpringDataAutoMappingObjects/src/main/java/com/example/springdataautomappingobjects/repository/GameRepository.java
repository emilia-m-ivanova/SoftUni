package com.example.springdataautomappingobjects.repository;

import com.example.springdataautomappingobjects.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    Optional<Game> deleteGameById(Long id);

    Optional<Game> findByTitle(String title);
}
