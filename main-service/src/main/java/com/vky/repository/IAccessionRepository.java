package com.vky.repository;

import com.vky.repository.entity.Accession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccessionRepository extends JpaRepository<Accession, Long> {
}
