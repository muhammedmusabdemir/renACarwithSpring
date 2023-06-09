package com.dev3.renACar.business.concretes;

import com.dev3.renACar.business.abstracts.BrandService;
import com.dev3.renACar.dataAccess.abstracts.BrandRepository;
import com.dev3.renACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Bu sinif bir business nesnesidir
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        //is kurallari
        return brandRepository.getAll();
    }
}
