package io.getarrays.securecapita.query;

public class PurchaseQuery {
    public static final String SELECT_PURCHASE_REQUESTS_BY_ID_QUERY ="SELECT * FROM PurchaseRequisition WHERE id = :id";
    public static final String INSERT_PurchaseRequisition_REQUEST_QUERY = "INSERT INTO PurchaseRequisition (user_id, date, department_code,receiver_email, reason, item_number, Item_description, unit_price, quantity, estimated_value,  signature) VALUES (:userId, :date, :departmentCode,:receiverEmail, :reason, :itemNumber, :itemDescription, :unitPrice, :quantity, :estimatedValue, :signature)";

    public static final String Get_PurchaseRequisitions_To_User_REQUEST_QUERY="SELECT * FROM purchaseRequests";
    public static final  String  UPDATE_PURCHASE_SIGNATURE_IMAGE_QUERY="";




}
