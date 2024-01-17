package io.getarrays.securecapita.repository.implementation;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.exception.ApiException;
import io.getarrays.securecapita.query.AdminPurchaseQuery;
import io.getarrays.securecapita.query.BodyOfSurveyQuery;
import io.getarrays.securecapita.query.PrincipalAdministratorPurchaseRequisitionQuery;
import io.getarrays.securecapita.query.BodyOfSurveyQuery.*;
import io.getarrays.securecapita.repository.BodyOfSurveyRepository;
import io.getarrays.securecapita.repository.PrincipalAdministratorPurchaseRequisitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import static java.util.Map.of;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BodyOfSurveyRepositoryImpl implements BodyOfSurveyRepository<BodyOfSurvey> {

    private final NamedParameterJdbcTemplate jdbc;
    public BodyOfSurveyQuery adminPurchaseQuery;
    RowMapper<BodyOfSurvey> rowMapper = (rs, rowNum) -> {
        BodyOfSurvey  bodyOfSurvey = new BodyOfSurvey();
        bodyOfSurvey .setId(rs.getLong("id"));
        bodyOfSurvey .setDate(rs.getDate("date"));
        bodyOfSurvey .setReceiverEmail(rs.getString("receiverEmail"));
        bodyOfSurvey .setSignature(rs.getString("signature"));
        bodyOfSurvey .setUserId(rs.getLong("user_id"));
        return  bodyOfSurvey ;
    };


    @Override
    public BodyOfSurvey create(BodyOfSurvey bodyOfSurvey, Long userId) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(bodyOfSurvey, userId);
        jdbc.update(BodyOfSurveyQuery.INSERT_BodyOfSurvey_REQUEST_QUERY, parameters, holder);
        return bodyOfSurvey;
    }
    private SqlParameterSource getSqlParameterSource(BodyOfSurvey bodyOfSurvey, Long userId) {
        return new MapSqlParameterSource()
                .addValue("userId",bodyOfSurvey.getUserId())
                .addValue("id",bodyOfSurvey.getId())
                .addValue("date", bodyOfSurvey.getDate())
                .addValue("receiverEmail", bodyOfSurvey.getReceiverEmail())

                .addValue("signature", bodyOfSurvey.getSignature());
    }


    @Override
    public BodyOfSurvey get(Long id) {
        try {

            return jdbc.queryForObject(BodyOfSurveyQuery.SELECT_BODY_SURVEY_BY_ID_QUERY, of("id", id), rowMapper);

        } catch (EmptyResultDataAccessException exception) {
            throw new ApiException("No BOY REQUESTS found by id: " + id);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }



}
