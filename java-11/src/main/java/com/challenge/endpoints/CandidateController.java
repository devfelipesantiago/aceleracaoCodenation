package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    CandidateMapper mapper;

    @GetMapping
    ResponseEntity<List<CandidateDTO>> getCandidateByCompanyId(@RequestParam(name = "companyId") Optional<Long> companyId) {
        return ResponseEntity.ok(mapper.map(this.candidateService.findByCompanyId(companyId.get())));
    }

    @GetMapping("/{user}/{acceleration}/{company}")
    ResponseEntity<CandidateDTO> getCandidateByUserAccelerationCompanyId(
            @PathVariable("user") Long userID,
            @PathVariable("acceleration") Long accelerationID,
            @PathVariable("company") Long companyID){
        Optional<Candidate> optionalCandidate = this.candidateService.findById(userID,companyID,accelerationID);
        return optionalCandidate.map(candidate -> ResponseEntity.ok(mapper.map(candidate))).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
