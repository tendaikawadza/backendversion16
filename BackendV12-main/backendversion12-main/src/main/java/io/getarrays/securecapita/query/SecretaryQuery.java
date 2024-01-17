package io.getarrays.securecapita.query;

public class SecretaryQuery {
    public static String INSERT_Secretary_REQUEST_QUERY="INSERT INTO Secretary (user_id, date,receiver_email, signature) VALUES (:userId, :date,:receiverEmail, :signature)";;
}
