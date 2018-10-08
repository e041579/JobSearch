/**
 * 
 */
package com.careers.microservices.job.search.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.careers.microservices.job.search.entities.Careers;

/**
 * @author VIVEK
 *
 */
@Repository
public interface CareersRepository extends CrudRepository<Careers, Long>, JpaSpecificationExecutor<Careers> {

	
}
