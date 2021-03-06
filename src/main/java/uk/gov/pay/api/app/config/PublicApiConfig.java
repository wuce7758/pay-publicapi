package uk.gov.pay.api.app.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PublicApiConfig extends Configuration {
    @NotNull
    private String baseUrl;
    @NotNull
    private String connectorUrl;
    @NotNull
    private String publicAuthUrl;
    @NotNull
    private String graphiteHost;
    @NotNull
    private String graphitePort;
    @Valid
    @NotNull
    @JsonProperty("jerseyClientConfig")
    private RestClientConfig restClientConfig;

    @Valid
    @NotNull
    @JsonProperty("rateLimiter")
    private RateLimiterConfig rateLimiterConfig;

    private String apiKeyHmacSecret;

    public RestClientConfig getRestClientConfig() {
        return restClientConfig;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getConnectorUrl() {
        return connectorUrl;
    }

    public String getPublicAuthUrl() {
        return publicAuthUrl;
    }

    public RateLimiterConfig getRateLimiterConfig() {
        return rateLimiterConfig;
    }

    public String getApiKeyHmacSecret(){
        return apiKeyHmacSecret;
    }
    public String getGraphiteHost() {
        return graphiteHost;
    }

    public String getGraphitePort() {
        return graphitePort;
    }
}
