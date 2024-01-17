package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;
import io.getarrays.securecapita.domain.HttpResponse;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.service.BodyOfSurveyService;
import io.getarrays.securecapita.service.DeputyHeadAdministrationRequisitionService;
import io.getarrays.securecapita.service.UserService;
import io.getarrays.securecapita.service.implementation.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static io.getarrays.securecapita.utils.UserUtils.getAuthenticatedUser;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;
@RestController
@RequestMapping(path = "/deputyHeadAdministration")
@RequiredArgsConstructor
@Slf4j
public class DeputyHeadAdministrationRequisitionResource {

    private final DeputyHeadAdministrationRequisitionService deputyHeadAdministrationRequisitionService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public ResponseEntity<HttpResponse> createDeputyHeadAdministrationRequisition(@RequestBody DeputyHeadAdministrationRequisition deputyHeadAdministrationRequisition, Authentication authentication) {
        UserDTO user = userService.getUserByEmail(getAuthenticatedUser(authentication).getEmail());
        DeputyHeadAdministrationRequisition createdBodyOfSurvey = deputyHeadAdministrationRequisitionService.createDeputyHeadAdministrationRequisition(deputyHeadAdministrationRequisition, user.getId());

        String email = deputyHeadAdministrationRequisition.getReceiverEmail();
        String subject = "Purchase Request Verification From Deputy Head of administration";
        String message = "Purchase request has been sent for Attention Name: " + deputyHeadAdministrationRequisition.getReceiverEmail() +
                "\n\nA purchase request email verification has been sent to: " + deputyHeadAdministrationRequisition.getReceiverEmail();
        emailService.sendEmail(email, subject, message);

        HttpResponse response = HttpResponse.builder()
                .timeStamp(now().toString())

                .message("Body of survey created successfully")
                .status(OK)
                .statusCode(OK.value())
                .build();

        return ResponseEntity.ok(response);
    }








}
