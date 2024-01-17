package io.getarrays.securecapita.repository;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;

public interface BodyOfSurveyRepository<T extends BodyOfSurvey> {

    T create(T data, Long userId);

    T get(Long id);
}
