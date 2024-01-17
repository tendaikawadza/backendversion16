package io.getarrays.securecapita.repository.implementation;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.HeadAdminPurchaseRequisition;
import io.getarrays.securecapita.query.BodyOfSurveyQuery;
import io.getarrays.securecapita.query.HeadAdministrationQuery;
import io.getarrays.securecapita.repository.BodyOfSurveyRepository;
import io.getarrays.securecapita.repository.HeadAdministrationRepository;
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
public class HeadAdministrationRepositoryImpl implements HeadAdministrationRepository<HeadAdminPurchaseRequisition> {

private final NamedParameterJdbcTemplate jdbc;
public HeadAdministrationQuery adminPurchaseQuery;
        RowMapper<HeadAdminPurchaseRequisition> rowMapper = (rs, rowNum) -> {
                HeadAdminPurchaseRequisition  headAdminPurchaseRequisition = new HeadAdminPurchaseRequisition();
                headAdminPurchaseRequisition .setId(rs.getLong("id"));
                headAdminPurchaseRequisition .setDate(rs.getDate("date"));
                headAdminPurchaseRequisition .setReceiverEmail(rs.getString("receiverEmail"));
                headAdminPurchaseRequisition .setSignature(rs.getString("signature"));
                headAdminPurchaseRequisition .setUserId(rs.getLong("user_id"));
        return  headAdminPurchaseRequisition ;
        };


@Override
public HeadAdminPurchaseRequisition create(HeadAdminPurchaseRequisition headAdminPurchaseRequisition, Long userId) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(headAdminPurchaseRequisition, userId);
        jdbc.update(BodyOfSurveyQuery.INSERT_BodyOfSurvey_REQUEST_QUERY, parameters, holder);
        return headAdminPurchaseRequisition;
        }
private SqlParameterSource getSqlParameterSource(HeadAdminPurchaseRequisition headAdminPurchaseRequisition, Long userId) {
        return new MapSqlParameterSource()
        .addValue("userId",headAdminPurchaseRequisition.getUserId())
        .addValue("id",headAdminPurchaseRequisition.getId())
        .addValue("date", headAdminPurchaseRequisition.getDate())
        .addValue("receiverEmail", headAdminPurchaseRequisition.getReceiverEmail())

        .addValue("signature", headAdminPurchaseRequisition.getSignature());
        }



        }

