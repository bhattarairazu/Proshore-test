package com.proshore.task.demo.repository;

import com.proshore.task.demo.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery,Integer> {

    @Query(value = "Select * from battery where cast (postcode as int) between ?1 and ?2 order by name asc",nativeQuery = true)
    List<Battery> findAllByPostcodeBetween(Integer start,Integer end);
}
