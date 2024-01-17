package io.getarrays.securecapita.issues.cts.ctspens;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j

public class CtspensImpl implements Ctspensrepository< Ctspens> {
    private final NamedParameterJdbcTemplate jdbc;
    public CtspensQuery ctspensQuery;


    @Override
    public Ctspens createctsdt (Ctspens ctspens)

    {





        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(ctspens);
        jdbc.update(ctspensQuery.INSERT_Ctspens_QUERY, parameters, holder);
        return ctspens;



    }

    private SqlParameterSource getSqlParameterSource(Ctspens ctspens) {
        return new MapSqlParameterSource()


                .addValue("id",ctspens.getId())
                .addValue("dateReceived", ctspens.getDateReceived())
                .addValue("quantityReceived", ctspens.getQuantityReceived())
                .addValue("runningBalance", ctspens.getRunningBalance());
}
}
