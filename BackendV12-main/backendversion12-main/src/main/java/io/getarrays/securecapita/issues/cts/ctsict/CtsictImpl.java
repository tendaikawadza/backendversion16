package io.getarrays.securecapita.issues.cts.ctsict;

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
public class CtsictImpl implements Ctsictrepository<Ctsict>

    {
        private final NamedParameterJdbcTemplate jdbc;
        public CtsictQuery ctsictQuery;


        @Override
        public Ctsict  createctsdt(Ctsict ctsict)

        {


            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(ctsict);
            jdbc.update(ctsictQuery.INSERT_Ctsict_EQUEST_QUERY, parameters, holder);
            return ctsict;


        }

        private SqlParameterSource getSqlParameterSource(Ctsict ctsict) {
        return new MapSqlParameterSource()


                .addValue("id",ctsict.getId())
                .addValue("dateReceived", ctsict.getDateReceived())
                .addValue("quantityReceived", ctsict.getQuantityReceived())
                .addValue("runningBalance", ctsict.getRunningBalance());
    }
}
