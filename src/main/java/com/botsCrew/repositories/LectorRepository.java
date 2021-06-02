package com.botsCrew.repositories;

import com.botsCrew.models.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findByNameContaining(String name);

    Lector findByName(String name);

    Lector findAllById(int id);

    @Query("SELECT p FROM Lector p WHERE CONCAT(p.name, ' ', p.salary, ' ', p.degree) LIKE %?1%")
    List<Lector> search(String template);

    List<Lector> findByNameLike(String template);
}
