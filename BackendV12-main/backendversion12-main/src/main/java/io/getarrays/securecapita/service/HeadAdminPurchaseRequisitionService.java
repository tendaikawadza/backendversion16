package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;
import io.getarrays.securecapita.domain.HeadAdminPurchaseRequisition;

public interface HeadAdminPurchaseRequisitionService {
    HeadAdminPurchaseRequisition createHeadAdminPurchaseRequisition
            (HeadAdminPurchaseRequisition headAdminPurchaseRequisition, Long userId);
}
