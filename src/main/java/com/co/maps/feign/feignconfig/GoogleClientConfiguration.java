package com.co.maps.feign.feignconfig;

import com.co.maps.feign.clients.GoogleMapsClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class GoogleClientConfiguration {

    private GoogleMapsClient googleMapsClient = createClient(GoogleMapsClient.class, "http://localhost:8080/maps.googleapis.com");

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, uri);
    }

    public GoogleMapsClient getGoogleClient() {
        return googleMapsClient;
    }

}
