
package com.co.maps.feign.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GoogleMaps {

    public List<String> destinationAddresses;
    public List<String> originAddresses;
    public List<Row> rows;
    public String status;

}
