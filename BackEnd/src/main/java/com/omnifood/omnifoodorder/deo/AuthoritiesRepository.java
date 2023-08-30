package com.omnifood.omnifoodorder.deo;

import com.omnifood.omnifoodorder.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,Long> {
}
