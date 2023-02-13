package com.shein.KameleoonTrialTest.reository;

import com.shein.KameleoonTrialTest.entity.DelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelEntRepo extends JpaRepository<DelEntity, Long> {
}
