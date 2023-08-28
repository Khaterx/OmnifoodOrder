package com.omnifood.omnifoodorder.deo;

import com.omnifood.omnifoodorder.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

    public List<State> findStateByCountryCode(String code);
}
