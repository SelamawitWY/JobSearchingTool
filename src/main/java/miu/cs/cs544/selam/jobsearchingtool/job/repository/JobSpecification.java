package miu.cs.cs544.selam.jobsearchingtool.job.repository;

import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JobSpecification {

    public static Specification<Job> hasSalaryAndCompanyState(double salary, String state) {
        return new Specification<Job>() {
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate salaryPredicate = criteriaBuilder.greaterThan(root.get("salary"), salary);
                Predicate companyStatePredicate = criteriaBuilder.equal(root.get("company").get("address").get("state"),
                        state);
                Predicate andPredicate = criteriaBuilder.and(salaryPredicate, companyStatePredicate);

                return andPredicate;
            }
        };
    }

    public static Specification<Job> hasSkillByLanguage(String language) {
        return new Specification<Job>() {
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate skillPredicate = criteriaBuilder.greaterThan(root.get("skills").get("language"), language);

                return skillPredicate;
            }
        };
    }
}
