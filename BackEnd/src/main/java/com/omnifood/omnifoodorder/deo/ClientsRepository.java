package com.omnifood.omnifoodorder.deo;

import com.omnifood.omnifoodorder.dto.PurchaseRequest;
import com.omnifood.omnifoodorder.dto.PurchaseResponse;
import com.omnifood.omnifoodorder.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients,Long> {
}
