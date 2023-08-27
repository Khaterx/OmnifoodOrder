package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.deo.StateRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class StateServices {

    @Autowired
    private StateRepository stateRepository;

}
