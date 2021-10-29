package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id") Long id) {
        return accelerationService.findById(id);
    }

    @GetMapping
    public Iterable<Acceleration> findAll(@PathParam("companyId") Long companyId) {
        return  accelerationService.findByCompanyId(companyId);
    }
}
