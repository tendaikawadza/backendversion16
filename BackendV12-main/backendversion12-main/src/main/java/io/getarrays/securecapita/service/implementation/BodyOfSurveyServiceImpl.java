package io.getarrays.securecapita.service.implementation;

import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;
import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.repository.BodyOfSurveyRepository;
import io.getarrays.securecapita.repository.DeputyHeadPurchaseRequestRepository;
import io.getarrays.securecapita.repository.UserRepository;
import io.getarrays.securecapita.service.BodyOfSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BodyOfSurveyServiceImpl implements BodyOfSurveyService {
    private final UserRepository<User> userRepository;


    private final BodyOfSurveyRepository<BodyOfSurvey> bodyOfSurveyRepository;




    @Override
    public BodyOfSurvey    createBodyOfSurvey(BodyOfSurvey bodyOfSurvey, Long userId) {
        return bodyOfSurveyRepository.create(


                bodyOfSurvey, userId);
    }

    @Override
    public BodyOfSurvey  getBodyOfSurveyById(Long id) {
        return (BodyOfSurvey)bodyOfSurveyRepository .get(id);
    }




}
