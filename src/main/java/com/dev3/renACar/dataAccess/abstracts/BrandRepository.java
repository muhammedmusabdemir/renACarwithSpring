package com.dev3.renACar.dataAccess.abstracts;

import com.dev3.renACar.entities.concretes.Brand;


import java.util.List;


public interface BrandRepository {
    List<Brand> getAll();

}
