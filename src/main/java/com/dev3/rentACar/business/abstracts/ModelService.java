package com.dev3.rentACar.business.abstracts;

import com.dev3.rentACar.business.requests.CreateModelRequest;
import com.dev3.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
