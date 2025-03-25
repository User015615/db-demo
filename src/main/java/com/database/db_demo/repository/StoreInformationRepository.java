package com.database.db_demo.repository;

import java.util.List;
import com.database.db_demo.entity.StoreInformation;
import java.util.Optional;

import jakarta.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.repository.CrudRepository;

public interface StoreInformationRepository extends CrudRepository<StoreInformation, Integer> {
    List<StoreInformation> findByStoreName(String name);
    List<StoreInformation> findByStorePhoneNumber(String phoneNumber);
    List<StoreInformation> findByStoreDetail(String detail);
    Optional<StoreInformation> findById(Integer id);

}
