package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    CompanyRepository repository;

    @Override
    public Company save(Company object) {
        // TODO Auto-generated method stub
        return repository.save(object);
    }

    @Override
    public Optional<Company> findById(Long id) {
        // TODO Auto-generated method stub
        return repository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        // TODO Auto-generated method stub
        return repository.findDistinctByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        // TODO Auto-generated method stub
        return repository.findByCandidatesIdUserId(userId);
    }

}