package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompany(@PathVariable("id") Long id) {
        Optional<Company> company = this.companyService.findById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Company> listByAccelerationIdOrUserId(
            @RequestParam(required = false) Long accelerationId,
            @RequestParam(required = false) Long userId
    ){
        if (accelerationId != null) return companyService.findByAccelerationId(accelerationId);
        if (userId != null) return companyService.findByUserId(userId);

        return Collections.emptyList();
    }

}
