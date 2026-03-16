package com.harshit.traffic_system.controller;

import com.harshit.traffic_system.model.Challan;
import com.harshit.traffic_system.repository.ChallanRepository;
import com.harshit.traffic_system.pdf.ChallanPdfGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challans")
public class ChallanController {

    @Autowired
    private ChallanRepository challanRepository;


    // Add Challan
    @PostMapping
    public Challan addChallan(@RequestBody Challan challan) {

        List<Challan> previous = challanRepository.findByVehicleNumber(challan.getVehicleNumber());

        int offenseCount = previous.size() + 1;

        if (offenseCount == 1) {
            challan.setFineAmount(1000);
        } else if (offenseCount == 2) {
            challan.setFineAmount(2000);
        } else {
            challan.setFineAmount(5000);
        }

        challan.setStatus("UNPAID");

        return challanRepository.save(challan);
    }

    // Get All Challans
    @GetMapping
    public List<Challan> getAllChallans() {
        return challanRepository.findAll();
    }


    // Pay Fine
    @PutMapping("/pay/{id}")
    public String payFine(@PathVariable int id) {

        Challan challan = challanRepository.findById(id).orElse(null);

        if (challan == null) {
            return "Challan not found";
        }

        challan.setStatus("PAID");
        challanRepository.save(challan);

        return "Fine Paid Successfully";
    }


    // Generate PDF
    @GetMapping("/generate/{id}")
    public String generatePdf(@PathVariable int id) {

        Challan challan = challanRepository.findById(id).orElse(null);

        if (challan == null) {
            return "Challan not found";
        }

        ChallanPdfGenerator.generatePdf(challan);

        return "PDF Generated Successfully";
    }
}