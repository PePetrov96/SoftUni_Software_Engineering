package com.resellerapp.repository;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
    @Query("SELECT c FROM Condition c WHERE c.conditionName = :name")
    Condition findByConditionName(@Param("name") String conditionName);

    Condition findFirstByConditionName(ConditionName conditionName);

}
