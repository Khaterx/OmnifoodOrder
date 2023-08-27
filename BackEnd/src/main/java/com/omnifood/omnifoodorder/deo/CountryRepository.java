package com.omnifood.omnifoodorder.deo;

import com.omnifood.omnifoodorder.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
