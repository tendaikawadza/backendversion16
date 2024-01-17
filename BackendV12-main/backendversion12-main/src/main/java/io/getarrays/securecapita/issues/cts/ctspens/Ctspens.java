package io.getarrays.securecapita.issues.cts.ctspens;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Ctspens {
    private Long id;
    private Date dateReceived;
    private String fromWhomReceived;
    private String productReceived;
    private int quantityReceived;
    private int runningBalance = 0;
}
