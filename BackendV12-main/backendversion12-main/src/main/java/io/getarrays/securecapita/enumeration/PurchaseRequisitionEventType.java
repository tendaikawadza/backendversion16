package io.getarrays.securecapita.enumeration;

public enum PurchaseRequisitionEventType {
    ADMIN_OFFICER(" ADMIN OFFICE SIGNED"),
    ASSIST_ADMINISTRATOR(" ADMIN OFFICE SIGNED"),
    PRINCIPAL_ADMIN(" ADMIN OFFICE SIGNED"),
    BODY_SURVEY(" BODY SURVEY SIGNED"),
    Secretary(" ADMIN OFFICE SIGNED");

    private final String description;

    PurchaseRequisitionEventType(String description) {
        this.description = description;
    }


}
