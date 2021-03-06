package com.halter.herdservice.model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.halter.herdservice.model.Cow;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CowResponse implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    private String id;
    private String collarId;
    private String cowNumber;
    private String collarStatus;
    private LastLocation lastLocation;

    @Data
    class LastLocation implements Serializable{

        private static final long serialVersionUID = 7156526077883281623L;

        private String lat;
        @JsonProperty("long")
        private String lng;
    }

    public CowResponse(Cow cow) {
        this.setId(cow.getId().toString());
        this.setCollarId(cow.getCollarId());
        this.setCowNumber(cow.getCowNumber());
        this.setCollarStatus(cow.getCollarStatus());
        LastLocation lastKnownLoc = new LastLocation();
        lastKnownLoc.setLat(cow.getLastKnownLoc_lat().toString());
        lastKnownLoc.setLng(cow.getLastKnownLoc_lng().toString());
        this.setLastLocation(lastKnownLoc);
    }
}
