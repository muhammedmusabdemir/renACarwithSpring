package com.dev3.renACar.business.concretes;

import com.dev3.renACar.business.abstracts.BrandService;
import com.dev3.renACar.business.requests.CreateBrandRequest;
import com.dev3.renACar.business.responses.GetAllBrandsResponse;
import com.dev3.renACar.core.utilities.mappers.ModelMapperService;
import com.dev3.renACar.dataAccess.abstracts.BrandRepository;
import com.dev3.renACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sinif bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        //List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();

        //for (Brand brand : brands) {
        //    GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
        //    responseItem.setId(brand.getId());
        //    responseItem.setName(brand.getName());
        //    brandsResponse.add(responseItem);
        //}

        return brands.stream().
                map(brand->this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).toList();

        //is kurallari

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        //Brand brand = new Brand();
        //brand.setName(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }
}
