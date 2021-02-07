package io.github.seclay2.webhookservice.service;

import io.github.seclay2.webhookservice.model.DiscordRequest;
import io.github.seclay2.webhookservice.model.DiscordResponse;
import io.github.seclay2.webhookservice.model.HnpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class HnpRequestService {

    private RestTemplate restTemplate;

    private String url;

    private String token;

    private Logger logger = Logger.getLogger(getClass().getName());

    private HttpHeaders headers;

    @Autowired
    public HnpRequestService(RestTemplate restTemplate,
                             @Value("${hnp.webhook.url}") String url,
                             @Value("${hnp.webhook.token}") String token) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.token = token;
        this.headers = new HttpHeaders();
        this.headers.set("User-Agent", "Other");

        logger.info("Loaded property: hnp.webhook.url=" + url);
    }

    public DiscordRequest format(HnpRequest request) {
        return new DiscordRequest(request.toString());
    }

    public void send(DiscordRequest request) {

        logger.info("in HnpRequestService.send(): forwarding to webhook url: " + url);

        HttpHeaders postHeaders = headers;
        postHeaders.setContentType(MediaType.APPLICATION_JSON);
        postHeaders.set("token", token);

        logger.info(" HnpRequestService.send(): headers - " + postHeaders.toString());

        HttpEntity<DiscordRequest> entity = new HttpEntity<>(request, headers);

        logger.info(" HnpRequestService.send(): entity - " + entity.toString());

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            logger.info("Request Successful: " + response.getBody());
        }
        else {
            logger.info("Request Failed: " + response.getStatusCode());
        }
    }

    public String test() {
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }
}
