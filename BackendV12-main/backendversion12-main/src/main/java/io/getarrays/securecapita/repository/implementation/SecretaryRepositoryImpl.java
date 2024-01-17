package io.getarrays.securecapita.repository.implementation;

import io.getarrays.securecapita.domain.Secretary;
import io.getarrays.securecapita.query.SecretaryQuery;
import io.getarrays.securecapita.repository.SecretaryRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.query.AdminPurchaseQuery;
import io.getarrays.securecapita.query.BodyOfSurveyQuery;
import io.getarrays.securecapita.query.PrincipalAdministratorPurchaseRequisitionQuery;
import io.getarrays.securecapita.repository.BodyOfSurveyRepository;
import io.getarrays.securecapita.repository.PrincipalAdministratorPurchaseRequisitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
@Slf4j

public class SecretaryRepositoryImpl implements SecretaryRepository<Secretary> {

private final NamedParameterJdbcTemplate jdbc;
public SecretaryQuery adminPurchaseQuery;
        RowMapper<Secretary> rowMapper = (rs, rowNum) -> {
            Secretary  secretary = new Secretary();
            secretary .setId(rs.getLong("id"));
            secretary .setDate(rs.getDate("date"));
            secretary .setReceiverEmail(rs.getString("receiverEmail"));
            secretary .setSignature(rs.getString("signature"));
            secretary .setUserId(rs.getLong("user_id"));
        return  secretary ;
        };


@Override
public Secretary create(Secretary secretary, Long userId) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(secretary, userId);
        jdbc.update(BodyOfSurveyQuery.INSERT_BodyOfSurvey_REQUEST_QUERY, parameters, holder);
        return secretary;
        }
private SqlParameterSource getSqlParameterSource(Secretary secretary, Long userId) {
        return new MapSqlParameterSource()
        .addValue("userId",secretary.getUserId())
        .addValue("id",secretary.getId())
        .addValue("date", secretary.getDate())
        .addValue("receiverEmail", secretary.getReceiverEmail())

        .addValue("signature", secretary.getSignature());
        }



        }

