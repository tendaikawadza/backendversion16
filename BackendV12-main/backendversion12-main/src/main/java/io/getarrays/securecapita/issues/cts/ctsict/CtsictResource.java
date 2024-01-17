package io.getarrays.securecapita.issues.cts.ctsict;

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
@RequestMapping("/ctsict")
public class CtsictResource {

    private CtsdtService ctsdtService;

    @PostMapping("/create")
    public ResponseEntity<Ctsdt> createCtsdt(@RequestBody Ctsdt ctsdt) {
        Ctsdt createCtsdt = ctsdtService.createCtsdt(ctsdt);
        HttpResponse response = HttpResponse.builder()
                .timeStamp(now().toString())
                .message("created successfully")
                .status(OK)
                .statusCode(OK.value())
                .build();

        return ResponseEntity.ok(createCtsdt);
    }

}
