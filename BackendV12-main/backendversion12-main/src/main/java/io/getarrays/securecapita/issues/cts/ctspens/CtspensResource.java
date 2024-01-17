package io.getarrays.securecapita.issues.cts.ctspens;

import io.getarrays.securecapita.domain.HttpResponse;
import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdt;
import io.getarrays.securecapita.issues.cts.ctsdt.CtsdtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;
@RestController
@RequestMapping("/ctspens")
public class CtspensResource {
    private CtspensService ctspensService;

    @PostMapping("/create")
    public ResponseEntity<Ctspens> createCtspens(@RequestBody Ctspens ctspens) {
        Ctspens createCtspens = ctspensService.createCtspens(ctspens);
        HttpResponse response = HttpResponse.builder()
                .timeStamp(now().toString())
                .message("created successfully")
                .status(OK)
                .statusCode(OK.value())
                .build();

        return ResponseEntity.ok(createCtspens);
    }
}
