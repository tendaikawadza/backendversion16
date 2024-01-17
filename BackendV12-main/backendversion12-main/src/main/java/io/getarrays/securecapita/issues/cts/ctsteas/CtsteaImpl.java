package io.getarrays.securecapita.issues.cts.ctsteas;

import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdt;
import io.getarrays.securecapita.issues.cts.ctsdt.CtsdtQuery;
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
public class CtsteaImpl  implements  CtsteaRepository < Ctstea> {
    private final NamedParameterJdbcTemplate jdbc;
    public CtsdtQuery ctsdtQuery;




    @Override
    public  Ctstea  createctstea    ( Ctstea ctstea) {


        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(ctstea);
        jdbc.update(ctsdtQuery.INSERT_Ctsdt_EQUEST_QUERY, parameters, holder);
        return ctstea;


    }



    private SqlParameterSource getSqlParameterSource(Ctstea ctstea) {
        return new MapSqlParameterSource()


                .addValue("id",ctstea.getId())
                .addValue("dateReceived", ctstea.getDateReceived())
                .addValue("quantityReceived", ctstea.getQuantityReceived())
                .addValue("runningBalance", ctstea.getRunningBalance());

    }




}
