package com.dev3.rentACar.webApi.controllers;


import com.dev3.rentACar.business.abstracts.BrandService;
import com.dev3.rentACar.business.requests.CreateBrandRequest;
import com.dev3.rentACar.business.requests.UpdateBrandRequest;
import com.dev3.rentACar.business.responses.GetAllBrandsResponse;
import com.dev3.rentACar.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;


    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
     return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}

//bugun de olmedik