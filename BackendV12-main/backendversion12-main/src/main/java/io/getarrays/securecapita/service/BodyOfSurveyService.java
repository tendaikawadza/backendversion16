package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.AdminPurchaseRequisition;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.PurchaseRequisition;


public interface BodyOfSurveyService {



    BodyOfSurvey createBodyOfSurvey
            (BodyOfSurvey bodyOfSurvey, Long userId);
    BodyOfSurvey getBodyOfSurveyById(Long id);



}
