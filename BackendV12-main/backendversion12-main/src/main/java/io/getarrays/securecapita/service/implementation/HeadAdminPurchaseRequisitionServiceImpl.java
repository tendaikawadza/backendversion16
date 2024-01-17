package io.getarrays.securecapita.service.implementation;

import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.enumeration.PurchaseRequest;
import io.getarrays.securecapita.repository.UserRepository;
import io.getarrays.securecapita.service.*;
import io.getarrays.securecapita.domain.*;
import io.getarrays.securecapita.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeadAdminPurchaseRequisitionServiceImpl implements HeadAdminPurchaseRequisitionService {

    private final UserRepository<User> userRepository;


    private final HeadAdministrationRepository<HeadAdminPurchaseRequisition> headAdministrationRepository;




    @Override
    public HeadAdminPurchaseRequisition createHeadAdminPurchaseRequisition(HeadAdminPurchaseRequisition headAdminPurchaseRequisition, Long userId) {
        return   headAdministrationRepository.create(headAdminPurchaseRequisition,userId)    ;                   //create(principalAdministratorPurchaseRequisition, userId);
    }

    @Service
    public static class PurchaseRequestServiceImpl implements PurchaseRequestService {

        @Override
        public String getPurchaseRequestProcessByName(String processName) {
            String processLabel = null;
            PurchaseRequest purchaseRequest = PurchaseRequest.getPurchaseRequestValueByName(processName);
            processLabel =  null != purchaseRequest ? purchaseRequest.getDescription() : "No Process's Name Found in the System";
            return processLabel;
        }
    }
}