/**
 * 
 */
package com.careers.microservices.job.search.repositories;

import static com.careers.microservices.job.search.constants.Constants.CONTAINS;
import static com.careers.microservices.job.search.constants.Constants.EQUAL;
import static com.careers.microservices.job.search.constants.Constants.GREATER_THAN;
import static com.careers.microservices.job.search.constants.Constants.LESS_THAN;
import static com.careers.microservices.job.search.constants.Constants.LIKE;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.careers.microservices.job.search.entities.Careers;

/**
 * @author Vivek
 *
 */
public class JobSpecification implements Specification<Careers> {

	private static final long serialVersionUID = 1235657465764754L;
	private FilterCriteria criteria;

	public JobSpecification(FilterCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Careers> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		switch (criteria.getFilterOperation()) {
		case EQUAL:
			return criteriaBuilder.equal(criteriaBuilder.lower(root.get(criteria.getFilterKey())),
					criteria.getFilterValue().toLowerCase());
		case GREATER_THAN:
			return criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.lower(root.get(criteria.getFilterKey())),
					criteria.getFilterValue().toString().toLowerCase());
		case LESS_THAN:
			return criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.lower(root.get(criteria.getFilterKey())),
					criteria.getFilterValue().toString().toLowerCase());
		case LIKE:
			return criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getFilterKey())),
					criteria.getFilterValue().toString().toLowerCase());
		case CONTAINS:
			return criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getFilterKey())),
					"%" + criteria.getFilterValue().toLowerCase() + "%");
		default:
			return null;
		}

	}

}
