package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("incidents")
public class IncidentResource {
    @RestClient
    IncidentRestClient incidentRestClient;

    @ConfigProperty(name = "APIKEY", defaultValue = "secret")
    String apiKey;

    @GET
    public List<Incident> getIncidents(){
       return incidentRestClient.getIncidents(apiKey);
    } 
}
