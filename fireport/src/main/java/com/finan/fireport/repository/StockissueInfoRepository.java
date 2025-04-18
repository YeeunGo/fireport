package com.finan.fireport.repository;

import com.finan.fireport.domain.StockIssueInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockissueInfoRepository extends JpaRepository<StockIssueInfo,Long> {
}
