package com.dev3.rentACar.dataAccess.abstracts;

import com.dev3.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {

    boolean existsByName(String name); //spring jpa keywords
}
