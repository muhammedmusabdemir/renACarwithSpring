package com.dev3.rentACar.dataAccess.abstracts;

import com.dev3.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {


}
