package io.getarrays.securecapita.repository;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.domain.Secretary;

public interface SecretaryRepository<T extends Secretary>  {
    T create(T data, Long userId);
}
