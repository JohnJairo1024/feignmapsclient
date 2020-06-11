package com.co.maps.feign.controllers;

import com.co.maps.feign.clients.GoogleMapsClient;
import com.co.maps.feign.feignconfig.GoogleClientConfiguration;
import com.co.maps.feign.models.GoogleMaps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
@SpringBootTest
@Slf4j
public class GoogleClientConfigurationTest {

    private GoogleMapsClient googleMapsClient;

    @Before
    public void setup() {
        GoogleClientConfiguration feignClientBuilder = new GoogleClientConfiguration();
        googleMapsClient = feignClientBuilder.getGoogleClient();
    }

    @Test
    public void getGoogles() {
        List<GoogleMaps> googleMaps = googleMapsClient.findAll();
        assertTrue(googleMaps.size() >= 2);
        log.info("{}", googleMaps);
    }

    @Test
    public void getGoogle() throws Exception {
        GoogleMaps googleMaps = googleMapsClient.findById(1);
        assertNotNull(googleMaps);
        log.info("{}", googleMaps);
    }

}
