package com.co.maps.feign.controllers;

import com.co.maps.feign.clients.GoogleMapsClient;
import com.co.maps.feign.models.GoogleMaps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoogleController {
    private Logger LOGGER = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    private GoogleMapsClient googleMapsClient;

    @GetMapping("/maps.googleapis.com/mapsall")
    public ResponseEntity<List<GoogleMaps>> getGoogles() {
        List<GoogleMaps> googles = googleMapsClient.findAll();
        LOGGER.info("{}", googles);
        return ResponseEntity.ok(googles);
    }

    @GetMapping("/maps.googleapis.com/maps/{id}")
    public ResponseEntity<GoogleMaps> getGoogle(
            @PathVariable("id") long id
    ) {
        GoogleMaps google = googleMapsClient.findById(id);
        LOGGER.info("{}", google);
        return ResponseEntity.ok(google);
    }

    @GetMapping("/maps.googleapis.com/maps")
    public ResponseEntity<List<GoogleMaps>> getByDistanceDuration(
            @RequestParam("destino") String destino,
            @RequestParam("origen") String origen
    ) {
        List<GoogleMaps> findByoriginAddresses = googleMapsClient.getByDistanceDuration(destino, origen);
        return ResponseEntity.ok(findByoriginAddresses);
    }

}
