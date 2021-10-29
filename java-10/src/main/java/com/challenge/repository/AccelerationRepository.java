package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    //	@Query("select c.id.acceleration from Candidate c where c.id.company.id = id")
    //	@Query("Select a from Acceleration a\n" +
    //			" join fetch a.candidates c\n" +
    //			" where 1=1\n" +
    //			" and c.id.company.id = companyId")
    @Query("SELECT c.id.acceleration FROM Candidate c WHERE c.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(Long companyId);

}
