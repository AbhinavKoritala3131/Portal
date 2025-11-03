package org.example.controller;


import org.example.entity.HR;
import org.example.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HRRepository hrRepository;

    @PreAuthorize("hasRole('HR') or hasRole('ADMIN')")
    @GetMapping("/getByWeek")
    public ResponseEntity<List<HR>> getByWeek(@RequestParam String week) {
       List<HR> available= hrRepository.findByWeek(week);
         if(available.isEmpty()){
             return ResponseEntity.noContent().build();

         }
         else {

             return ResponseEntity.ok(available);
         }
    }
}
