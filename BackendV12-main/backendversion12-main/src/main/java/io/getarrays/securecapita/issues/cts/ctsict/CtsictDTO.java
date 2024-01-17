package io.getarrays.securecapita.issues.cts.ctsict;

import java.util.Date;

public class CtsictDTO {

    private Long id;
    private Date dateReceived;
    private String fromWhomReceived;
    private String productReceived;
    private int quantityReceived;
    private int runningBalance = 0;
}
