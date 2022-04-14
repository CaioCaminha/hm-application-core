package com.home.manager.hmapplicationcore.repository;

import com.home.manager.hmapplicationcore.entity.NeighborhoodEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
public interface NeighborhoodRepository extends CrudRepository<NeighborhoodEntity, String> {

    Optional<NeighborhoodEntity> findByName(String name);

}
