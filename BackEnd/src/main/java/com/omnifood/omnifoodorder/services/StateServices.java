package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.deo.StateRepository;
import com.omnifood.omnifoodorder.model.State;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class StateServices {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates(){
        return stateRepository.findAll();
    }

}
