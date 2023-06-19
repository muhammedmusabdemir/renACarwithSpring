package com.dev3.rentACar.business.concretes;

import com.dev3.rentACar.business.abstracts.ModelService;
import com.dev3.rentACar.business.requests.CreateModelRequest;
import com.dev3.rentACar.business.responses.GetAllModelsResponse;
import com.dev3.rentACar.core.utilities.mappers.ModelMapperService;
import com.dev3.rentACar.dataAccess.abstracts.ModelRepository;
import com.dev3.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {

            List<Model> models = modelRepository.findAll();
            return models.stream().
                    map(model->this.modelMapperService.forResponse().
                            map(model,GetAllModelsResponse.class)).toList();



    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);

    }
}
