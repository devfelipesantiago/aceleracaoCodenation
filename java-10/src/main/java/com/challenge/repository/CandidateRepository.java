package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId,
                                                                        Long accelerationId);

    @Query("select c from Candidate c where c.id.company.id = :id")
    List<Candidate> findByCompanyId(@Param("id") Long companyId);

    @Query("select c from Candidate c where c.id.acceleration.id = :id")
    List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);
}
