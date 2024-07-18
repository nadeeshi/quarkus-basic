package com.nadee.lil.quarkus.web.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/api/rest/healthCheck")
@Produces("application/json")
public class HealthCheck {

    @GET
    public Response healthCheck() {
        // Simple health check logic. You can enhance this to check database connectivity, etc.
        return Response.ok(new HealthStatus("ok")).build();
    }

    // HealthStatus class to represent the health status
    public static class HealthStatus {
        private String status;

        public HealthStatus() {}

        public HealthStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
