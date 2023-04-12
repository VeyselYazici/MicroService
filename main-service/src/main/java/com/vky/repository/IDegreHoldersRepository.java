package com.vky.repository;


import com.vky.repository.entity.DegreeHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDegreHoldersRepository extends JpaRepository<DegreeHolders, Long> {
}
