package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("rest")
public class IncidentResource {
    @RestClient
    IncidentRestClient incidentRestClient;

    @ConfigProperty(name = "APIKEY", defaultValue = "secret")
    String apiKey;

    @GET
    @Fallback(fallbackMethod = "fallback")
    public List<Incident> getIncidents(){
        return incidentRestClient.getIncidents(apiKey);
    }

    public List<Incident> fallback(){
        return List.of(new Incident().setDate(new Date()).setDescription("fallback").setStatus(false));
    }
}
