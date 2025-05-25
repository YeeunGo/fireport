package com.finan.fireport.repository;

import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StockIssueInfoJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public void bulkInsert(List<StockIssueInfo> items) {

        String sql = "INSERT INTO stock_issue_info " +
                "(bas_dt, crno, isin_cd, itms_shrtn_cd, isin_cd_nm, stck_issu_cmpy_nm, " +
                "scrs_itms_kcd, scrs_itms_kcd_nm, stck_par_prc, issu_stck_cnt, " +
                "lstg_dt, lstg_abol_dt, dpsg_reg_dt, dpsg_can_dt, issu_frmt_clsf_nm) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                StockIssueInfo dto = items.get(i);
                log.info("Item 직전!! i: {}", i);
                log.info("Item 직전!! : {}", dto.getId().getCrno());
                ps.setObject(1, dto.getId().getBasDt());
                ps.setString(2, dto.getId().getCrno());
                ps.setString(3, dto.getIsinCd());
                ps.setString(4, dto.getItmsShrtnCd());
                ps.setString(5, dto.getIsinCdNm());
                ps.setString(6, dto.getStckIssuCmpyNm());
                ps.setString(7, dto.getScrsItmsKcd());
                ps.setString(8, dto.getScrsItmsKcdNm());
                ps.setObject(9, dto.getStckParPrc(), Types.BIGINT);
                ps.setObject(10, dto.getIssuStckCnt(),Types.BIGINT);
                ps.setObject(11, dto.getLstgDt());
                ps.setObject(12, dto.getLstgAbolDt());
                ps.setObject(13, dto.getDpsgRegDt());
                ps.setObject(14, dto.getDpsgCanDt());
                ps.setString(15, dto.getIssuFrmtClsfNm());
            }

            @Override
            public int getBatchSize() {
                return items.size();
            }
        });
    }
}
