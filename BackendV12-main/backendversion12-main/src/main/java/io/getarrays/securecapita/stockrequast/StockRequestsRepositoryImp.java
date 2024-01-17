package io.getarrays.securecapita.stockrequast;

import io.getarrays.securecapita.stockitemnew.StockRequest;
import io.getarrays.securecapita.stockitemnew.Stocks;
import io.getarrays.securecapita.stockitemnew.StocksRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
@Slf4j
public class StockRequestsRepositoryImp implements StockRequestsRepository {
//
//
//
//
//    @Override
//    public void save(Stocks stocks) {
//        log.info("saveEmployee dao impl ---- '{}'", stocks);
//
//        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//        mapSqlParameterSource.addValue("id", stocks.getId());
//        mapSqlParameterSource.addValue("username", stocks.getUsername());
//        mapSqlParameterSource.addValue("password", stocks.getPassword());
//        mapSqlParameterSource.addValue("department_requesting", stocks.getDepartmentRequesting());
//        mapSqlParameterSource.addValue("stock_request_date", stocks.getStockRequestDate());
//
//        String departmentCode = generateDepartmentCode(stocks.getDepartmentCode());
//        mapSqlParameterSource.addValue("department_code", departmentCode);
//        departmentCodeMap.put(stocks.getDepartmentCode(), departmentCode);
//        mapSqlParameterSource.addValue("purpose_of_issue", stocks.getPurposeOfIssue());
//        mapSqlParameterSource.addValue("stock_date", stocks.getStockDate());
//        mapSqlParameterSource.addValue("item_no", stocks.getItemNo());
//        mapSqlParameterSource.addValue("item_reference_no", stocks.getItemReferenceNo());
//        mapSqlParameterSource.addValue("item_description", stocks.getItemDescription());
//        mapSqlParameterSource.addValue("date_of_previous_issue", stocks.getDateOfPreviousIssue());
//        mapSqlParameterSource.addValue("previous_issue_quantity", stocks.getPreviousIssueQuantity());
//        mapSqlParameterSource.addValue("quantity_requested", stocks.getQuantityRequested());
//        mapSqlParameterSource.addValue("department_initiated_by", stocks.getDepartmentInitiatedBy());
//        mapSqlParameterSource.addValue("department_authorised_by", stocks.getDepartmentAuthorisedBy());
//        mapSqlParameterSource.addValue("department_confirmed_by", stocks.getDepartmentConfirmedBy());
//        mapSqlParameterSource.addValue("department_received_by", stocks.getDepartmentReceivedBy());
//        mapSqlParameterSource.addValue("designated_person_approval_name", stocks.getDesignatedPersonApprovalName());
//        mapSqlParameterSource.addValue("signature", stocks.getSignature());
//        mapSqlParameterSource.addValue("date_of_confirmation", stocks.getDateOfConfirmation());
//        mapSqlParameterSource.addValue("role", stocks.getRole());
//        namedParameterJdbcTemplate.update(INSERT, mapSqlParameterSource);
//
////        stocks.getStockRequests().forEach(stockRequest -> {
////            log.info("saveStock dao impl in Stock Request for loop  ---- '{}'", stocks);
////            saveStockRequest(stockRequest, stocks.getId());
////
////        });
//    }


}
