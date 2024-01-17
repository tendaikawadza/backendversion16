package io.getarrays.securecapita.issues.cts.ctsdt;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@RequiredArgsConstructor
@Slf4j
public class Ctsdtimpl implements Ctsdtrepository <Ctsdt>{
  private final NamedParameterJdbcTemplate jdbc;
public CtsdtQuery  ctsdtQuery;




  @Override
  public Ctsdt createctsdt(Ctsdt ctsdt) {


    KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource parameters = getSqlParameterSource(ctsdt);
    jdbc.update(ctsdtQuery.INSERT_Ctsdt_EQUEST_QUERY, parameters, holder);
    return ctsdt;


  }



  private SqlParameterSource getSqlParameterSource(Ctsdt ctsdt) {
    return new MapSqlParameterSource()


            .addValue("id",ctsdt.getId())
            .addValue("dateReceived", ctsdt.getDateReceived())
            .addValue("quantityReceived", ctsdt.getQuantityReceived())
            .addValue("runningBalance", ctsdt.getRunningBalance());

  }

}
