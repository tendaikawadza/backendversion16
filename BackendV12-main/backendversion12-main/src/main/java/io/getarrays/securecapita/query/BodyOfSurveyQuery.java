package io.getarrays.securecapita.query;

public class BodyOfSurveyQuery {
    public static String INSERT_BodyOfSurvey_REQUEST_QUERY = "INSERT INTO BodyOfSurvey (user_id, date,receiver_email, signature) VALUES (:userId, :date,:receiverEmail, :signature)";


    public static String SELECT_BODY_SURVEY_BY_ID_QUERY = "SELECT * FROM BodyOfSurvey WHERE id = :id";
}