package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    UserRepository repository;

    @Override
    public User save(User object) {
        // TODO Auto-generated method stub
        return this.repository.save(object);
    }

    @Override
    public Optional<User> findById(Long userId) {
        // TODO Auto-generated method stub
        return repository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        // TODO Auto-generated method stub
        return repository.findByCandidatesIdAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        // TODO Auto-generated method stub
        return repository.findByCandidatesIdCompanyId(companyId);
    }

}
