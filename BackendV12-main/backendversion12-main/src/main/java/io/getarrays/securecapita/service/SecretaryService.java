package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.domain.Secretary;

public interface SecretaryService {
    Secretary createPrincipalAdministratorPurchaseRequisition(PrincipalAdministratorPurchaseRequisition principalAdministratorPurchaseRequisition, Long userId);

    Secretary createSecretary(Secretary secretary, Long id);
}

