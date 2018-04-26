package com.restint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restint.model.Award;


@Repository
public interface AwardDao extends JpaRepository<Award,Long>{

}
