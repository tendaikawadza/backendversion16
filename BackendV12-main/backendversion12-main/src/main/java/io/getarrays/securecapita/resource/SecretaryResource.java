package io.getarrays.securecapita.resource;
import io.getarrays.securecapita.domain.AdminPurchaseRequisition;
import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.Secretary;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.service.AdminPurchaseRequisitionService;
import io.getarrays.securecapita.service.PurchaseRequisitionService;
import io.getarrays.securecapita.service.SecretaryService;
import io.getarrays.securecapita.service.UserService;
import io.getarrays.securecapita.service.implementation.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.getarrays.securecapita.utils.UserUtils.getAuthenticatedUser;

@RestController
@RequestMapping(path = "/secretary")
@RequiredArgsConstructor
@Slf4j
public class SecretaryResource {
    private final SecretaryService secretaryService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public ResponseEntity<Secretary> createSecretary(@RequestBody Secretary secretary, Authentication authentication) {
        UserDTO user = userService.getUserByEmail(getAuthenticatedUser(authentication).getEmail());
        Secretary createdSecretary = secretaryService.createSecretary(secretary, user.getId());

        String email = secretary.getReceiverEmail();
        String subject = "Purchase Request Send has been sent login Verification From Secretary";
        String message = "Hello " + secretary.getId() + " for Product Name " + secretary.getReceiverEmail() + ", " +
                "\nA Purchase Request Email Verification Was Sent To \n" + secretary.getReceiverEmail();
        emailService.sendEmail(email, subject, message);

        return ResponseEntity.ok(createdSecretary);
    }

}
