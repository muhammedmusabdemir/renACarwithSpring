package com.dev3.renACar.business.abstracts;

import com.dev3.renACar.business.requests.CreateBrandRequest;
import com.dev3.renACar.business.responses.GetAllBrandsResponse;

import java.util.List;

public interface BrandService {

    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);

}
