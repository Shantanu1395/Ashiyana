package com.ashiyana.core.Controllers;

import com.ashiyana.core.Services.CoreService;
import com.ashiyana.core.models.Customer;
import com.ashiyana.core.models.Plot;
import com.ashiyana.core.models.Site;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoreController {

    @Autowired
    private CoreService coreService;

    @PostMapping(value = "createCustomer")
    public ResponseEntity<?> createCustomer(@NonNull @RequestBody Customer customer) {
        try {
            String customerId = coreService.createCustomer(customer);
            return new ResponseEntity<>(customerId, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "createSite")
    public ResponseEntity<?> createSite(@NonNull @RequestBody Site site) {
        try {
            String siteId = coreService.createSite(site);
            return new ResponseEntity<>(siteId, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "createPlots")
    public ResponseEntity<?> createPlots(@NonNull @RequestBody List<Plot> plots) {
        try {
            List<String> siteIds = coreService.createPlots(plots);
            return new ResponseEntity<>(siteIds, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "holdPlot/{customerId}/{plotId}/{amount}")
    public ResponseEntity<?> holdPlot(@PathVariable String customerId, @PathVariable String plotId, @PathVariable double amount) {
        try {
            String siteId = coreService.holdPlot(customerId, plotId, amount);
            return new ResponseEntity<>(siteId, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }



}
