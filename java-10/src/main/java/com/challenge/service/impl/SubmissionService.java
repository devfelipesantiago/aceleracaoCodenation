package com.challenge.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface{

    @Autowired
    SubmissionRepository repository;

    @Override
    public Submission save(Submission object) {
        // TODO Auto-generated method stub
        return repository.save(object);
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        // TODO Auto-generated method stub
        return repository.findHigherScoreByChallengeId(challengeId);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        // TODO Auto-generated method stub
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }


}
