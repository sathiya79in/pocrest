package com.restint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restint.model.Plan;

public interface PlanDao extends JpaRepository<Plan, Long> {

}
