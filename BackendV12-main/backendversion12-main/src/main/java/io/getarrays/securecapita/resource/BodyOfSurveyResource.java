package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.HttpResponse;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.service.BodyOfSurveyService;
import io.getarrays.securecapita.service.PrincipalAdministratorPurchaseRequisitionService;
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
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/body-survey")
@RequiredArgsConstructor
@Slf4j
public class BodyOfSurveyResource {

    private final BodyOfSurveyService bodyOfSurveyService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public ResponseEntity<HttpResponse> createBodyOfSurvey(@RequestBody BodyOfSurvey bodyOfSurvey, Authentication authentication) {
        UserDTO user = userService.getUserByEmail(getAuthenticatedUser(authentication).getEmail());
        BodyOfSurvey createdBodyOfSurvey = bodyOfSurveyService.createBodyOfSurvey(bodyOfSurvey, user.getId());

        String email = bodyOfSurvey.getReceiverEmail();
        String subject = "Purchase Request Verification From Body of Survey";
        String message = "Purchase request has been sent for Attention Name: " + bodyOfSurvey.getReceiverEmail() +
                "\n\nA purchase request email verification has been sent to: " + bodyOfSurvey.getReceiverEmail();
        emailService.sendEmail(email, subject, message);

        HttpResponse response = HttpResponse.builder()
                .timeStamp(now().toString())

                .message("Body of survey created successfully")
                .status(OK)
                .statusCode(OK.value())
                .build();

        return ResponseEntity.ok(response);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<BodyOfSurvey> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bodyOfSurveyService.getBodyOfSurveyById(id));
    }



}
