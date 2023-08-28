package com.omnifood.omnifoodorder.deo;

import com.omnifood.omnifoodorder.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
