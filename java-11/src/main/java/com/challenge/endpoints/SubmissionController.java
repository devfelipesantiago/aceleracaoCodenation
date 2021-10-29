package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/submission")
public class SubmissionController {

    @Autowired
    SubmissionService submissionService;
    public SubmissionMapper submissionMapper;

    @GetMapping(value = "/submission")
    public ResponseEntity<List<Submission>> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        List<Submission> submissions = submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
        return ResponseEntity.ok().body(submissions);
    }

    @GetMapping
    public ResponseEntity<?> findByChallengeIdAndAccelerationId2(@RequestParam(required = false) Long challengeId,
                                                                @RequestParam(required = false) Long accelerationId) {
        return new ResponseEntity<>(submissionMapper.map(this.submissionService
                .findByChallengeIdAndAccelerationId(challengeId, accelerationId)),
                HttpStatus.OK);
    }
}
