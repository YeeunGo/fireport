package com.finan.fireport.repository;

import com.finan.fireport.domain.StockItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemInfoRepository extends JpaRepository<StockItemInfo,Long> {
}
