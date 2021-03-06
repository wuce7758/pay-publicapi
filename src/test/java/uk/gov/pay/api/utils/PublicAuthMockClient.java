package uk.gov.pay.api.utils;

import org.mockserver.client.server.MockServerClient;

import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.core.HttpHeaders.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class PublicAuthMockClient {

    private final MockServerClient mockClient;

    public PublicAuthMockClient(int mockServerPort) {
        this.mockClient = new MockServerClient("localhost", mockServerPort);
    }

    public void respondUnauthorised() {
        mockClient.when(request()
                .withMethod(GET)
                .withHeader(ACCEPT, APPLICATION_JSON))
                .respond(response().withStatusCode(401));

    }

    public void mapBearerTokenToAccountId(String bearerToken, String gatewayAccountId) {
        mockClient.when(request()
                .withPath("/v1/auth")
                .withMethod(GET)
                .withHeader(ACCEPT, APPLICATION_JSON)
                .withHeader(AUTHORIZATION, "Bearer " + bearerToken))
                .respond(response().withStatusCode(200).withBody("{\"account_id\" : \"" + gatewayAccountId + "\"}").withHeader(CONTENT_TYPE, APPLICATION_JSON));

    }

    public void respondWithError() {
        mockClient.when(request()
                .withMethod(GET)
                .withHeader(ACCEPT, APPLICATION_JSON))
                .respond(response().withStatusCode(500));

    }
}
