package com.finan.fireport.repository;

import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StockIssueInfoJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public void bulkInsert(List<StockIssueInfoResponse> StockIssueInfoResponses) {
        String sql = "INSERT INTO krx_snapshots " +
                "(stock_code, base_date, isin_code, market_code, stock_name, corporate_number, corporate_name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                StockIssueInfoResponse dto = StockIssueInfoResponses.get(i);
                ps.setString(1, dto.getStockCode());
                ps.setObject(2, dto.getBaseDate()); // LocalDate는 setObject 사용
                ps.setString(3, dto.getIsinCode());
                ps.setString(4, dto.getMarketType());
                ps.setString(5, dto.getStockName());
                ps.setString(6, dto.getCorporateNumber());
                ps.setString(7, dto.getCorporateName());
            }

            @Override
            public int getBatchSize() {
                return StockIssueInfoResponses.size();
            }
        });
    }
}
