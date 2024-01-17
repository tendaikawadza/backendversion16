package io.getarrays.securecapita.query;

public class PrincipalAdministratorPurchaseRequisitionQuery {
    public static String  SELECT_PrincipalAdministratorPurchaseRequisition_R_BY_ID_QUERY="SELECT * FROM BodyOfSurvey WHERE";
    public static final String   INSERT_PrincipalAdministratorPurchaseRequisition_REQUEST_QUERY = "INSERT INTO PrincipalAdministratorPurchaseRequisition (user_id, date,receiver_email, signature) VALUES (:userId, :date,:receiverEmail, :signature)";
}
