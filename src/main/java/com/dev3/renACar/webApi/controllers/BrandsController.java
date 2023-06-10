package com.dev3.renACar.webApi.controllers;


import com.dev3.renACar.business.abstracts.BrandService;
import com.dev3.renACar.business.requests.CreateBrandRequest;
import com.dev3.renACar.business.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;


    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll(){
     return brandService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
}

//bugun de olmedik