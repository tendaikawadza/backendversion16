package io.getarrays.securecapita.stockrequast;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class stock {
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date stockRequestDate;
    private String departmentRequesting;

    private String departmentCode;
    private String purposeOfIssue;

    private Integer itemNo;
    private String itemReferenceNo;
    private String itemDescription;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateOfPreviousIssue;
    private Integer previousIssueQuantity;

    private String signature;
}
