package com.restint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restint.model.VestTemplate;

@Repository
public interface VestTemplateDao extends JpaRepository<VestTemplate,Long>{

}
