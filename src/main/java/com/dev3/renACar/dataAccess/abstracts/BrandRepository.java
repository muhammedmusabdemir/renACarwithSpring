package com.dev3.renACar.dataAccess.abstracts;

import com.dev3.renACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {


}
