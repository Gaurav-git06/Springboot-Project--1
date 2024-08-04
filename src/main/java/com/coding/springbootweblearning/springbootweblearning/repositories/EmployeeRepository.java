package com.coding.springbootweblearning.springbootweblearning.repositories;

import com.coding.springbootweblearning.springbootweblearning.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gaura
 * @date 20-07-2024
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
