package com.vky.repository;

import com.vky.repository.entity.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViewsRepository extends JpaRepository<Views, Long> {
}
