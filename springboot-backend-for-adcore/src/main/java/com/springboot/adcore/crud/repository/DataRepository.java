package com.springboot.adcore.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.adcore.crud.model.Data;


@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

}
