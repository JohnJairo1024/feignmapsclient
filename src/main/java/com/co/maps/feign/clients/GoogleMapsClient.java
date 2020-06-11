package com.co.maps.feign.clients;

import com.co.maps.feign.models.GoogleMaps;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "google-client", url = "http://localhost:8080/maps.googleapis.com")
public interface GoogleMapsClient {

    @RequestLine("GET /mapsall")
    List<GoogleMaps> findAll();

    @RequestLine("GET /maps/{id}")
    GoogleMaps findById(@Param("id") long id);

    @RequestLine("GET /maps?destino={destino}&origen={origen}")
    List<GoogleMaps> getByDistanceDuration(@Param("destino") String destino, @Param("origen") String origen);
}
