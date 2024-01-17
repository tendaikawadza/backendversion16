package io.getarrays.securecapita.service.implementation;

//import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.domain.Secretary;
import io.getarrays.securecapita.service.PrincipalRequisitionService;
import io.getarrays.securecapita.service.SecretaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecretaryServiceImpl implements SecretaryService {


    @Override
    public Secretary createPrincipalAdministratorPurchaseRequisition(PrincipalAdministratorPurchaseRequisition principalAdministratorPurchaseRequisition, Long userId) {
        return null;
    }

    @Override
    public Secretary createSecretary(Secretary secretary, Long userId) {
        return null;


    }
}
