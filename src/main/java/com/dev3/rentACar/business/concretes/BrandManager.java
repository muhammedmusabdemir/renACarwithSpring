package com.dev3.rentACar.business.concretes;

import com.dev3.rentACar.business.abstracts.BrandService;
import com.dev3.rentACar.business.requests.CreateBrandRequest;
import com.dev3.rentACar.business.requests.UpdateBrandRequest;
import com.dev3.rentACar.business.responses.GetAllBrandsResponse;
import com.dev3.rentACar.business.responses.GetByIdBrandResponse;
import com.dev3.rentACar.business.rules.BrandBusinessRules;
import com.dev3.rentACar.core.utilities.mappers.ModelMapperService;
import com.dev3.rentACar.dataAccess.abstracts.BrandRepository;
import com.dev3.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Bu sinif bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


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
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);


    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        //Brand brand = new Brand();
        //brand.setName(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }




    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
