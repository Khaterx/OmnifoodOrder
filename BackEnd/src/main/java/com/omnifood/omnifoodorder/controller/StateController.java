package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.model.State;
import com.omnifood.omnifoodorder.services.StateServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/v1/api")
public class StateController {
    @Autowired
    private StateServices stateServices;

    @GetMapping("/getAllStates")
    public List<State> getAllStates(){
        return stateServices.getAllStates();
    }

    @GetMapping("/getStateByCountryCode")
    public List<State> getStatesByCountryCode( @RequestParam String code){
        return stateServices.getStateByCountryCode(code);
    }
}
