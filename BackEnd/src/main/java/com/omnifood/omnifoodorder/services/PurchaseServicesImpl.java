package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.deo.ClientsRepository;
import com.omnifood.omnifoodorder.dto.PurchaseRequest;
import com.omnifood.omnifoodorder.dto.PurchaseResponse;
import com.omnifood.omnifoodorder.model.ProductItems;
import com.omnifood.omnifoodorder.model.RequestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServicesImpl implements PurchaseServices {

    @Autowired
    private ClientsRepository clientsRepository;


    @Override
    @Transactional
    public PurchaseResponse addRequestOrder(PurchaseRequest purchaseRequest) {
        /* Step #1 */
        RequestOrder requestOrder = purchaseRequest.getRequestOrder();

        /* Step #2 */
        String uniqueCode = getUniqueCode();
        requestOrder.setCode(uniqueCode);

        /* Step #3 */
        /*requestOrder.setProductItems(purchaseRequest.getProductItems());
        purchaseRequest.getProductItems().forEach(item -> item.setRequestOrder(requestOrder));*/

        List<ProductItems> productItems = purchaseRequest.getProductItems();
        System.out.println(purchaseRequest.getProductItems().size());
        productItems.forEach(item -> requestOrder.addProductItems(item));

        /* Step #4 */
        requestOrder.setFromOrderAddress(purchaseRequest.getFromOrderAddress());
        requestOrder.setToOrderAddress(purchaseRequest.getToOrderAddress());

        /* Step #5 */


        purchaseRequest.getClients().addRequestOrder(requestOrder);
        requestOrder.setClients(purchaseRequest.getClients());

        /* Step #6 */
        clientsRepository.save(purchaseRequest.getClients());
        return new PurchaseResponse(purchaseRequest.getClients().getName(), uniqueCode);
    }

    private String getUniqueCode() {
        return UUID.randomUUID().toString();
    }
}
