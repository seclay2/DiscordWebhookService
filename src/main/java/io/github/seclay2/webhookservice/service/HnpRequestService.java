package io.github.seclay2.webhookservice.service;

import io.github.seclay2.webhookservice.model.discord.*;
import io.github.seclay2.webhookservice.model.hnp.AssignedUser;
import io.github.seclay2.webhookservice.model.hnp.HnpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        // create new discord request
        DiscordRequest discordRequest = new DiscordRequest();

        // setup field list
        List<DiscordField> fieldArrayList = new ArrayList<>();
        // get username assigned user list
        List<String> assignedUsersList = new ArrayList<>();
        for (AssignedUser user : request.getAssignedUsers()) {
            assignedUsersList.add(user.getUser().getUsername());
        }
        fieldArrayList.add(new DiscordField("Assigned Users", assignedUsersList.toString(), false));
        fieldArrayList.add(new DiscordField("Board", request.getBoard().getName() != null ? request.getBoard().getName() : "unnamed", false));
        fieldArrayList.add(new DiscordField("Importance", request.getImportanceLevel() != null ? request.getImportanceLevel().getName() : "unnamed", false));

        // setup embed
        discordRequest.addEmbed(
                new DiscordEmbed(
                        request.getTitle(),
                        null,
                        "WorkItem: " + request.getWorkItemId() + "\nStage: " + request.getStage().getStageId(),
                        constructLinkUrl(request),
                        request.getImportanceLevel().getColor() == null ? 0 : Integer.parseUnsignedInt(request.getImportanceLevel().getColor().substring(1), 16),
                        new DiscordFooter(request.getUpdateDate()),
                        new DiscordThumbnail("https://app.hacknplan.com/Images/icon.png"),
                        fieldArrayList
                ));

        discordRequest.setUsername("HacknPlan");

        return discordRequest;
    }

    private String constructLinkUrl(HnpRequest req) {
        // format https://app.hacknplan.com/p/{{ ProjectId }}/kanban?categoryId={{ Category.CategoryId }}&boardId={{ Board.BoardId }}
        return "https://app.hacknplan.com/p" + req.getProjectId()
                + "/kanban?categoryId=" + req.getCategory().getCategoryId()
                + "&boardId=" + req.getBoard().getBoardId();
    }

    public String send(DiscordRequest request) {
        // set additional post headers
        HttpHeaders postHeaders = headers;
        postHeaders.set("token", token);

        HttpEntity<DiscordRequest> entity = new HttpEntity<>(request, headers);

        logger.info(" HnpRequestService.send(): entity - " + entity.toString());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    // tests get request follow-through to discord webhook, relays discord webhook GET response
    public String testGet() {
        HttpEntity request = new HttpEntity(headers);
        logger.info("testPost(): " + request);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

    // tests POST request follow-through to discord webhook, will result in simple discord message post in channel
    public String testPost() {
        HttpHeaders headers = this.headers;
        headers.set("token", token);
        DiscordRequest reqObj = new DiscordRequest("hello");
        HttpEntity<DiscordRequest> request = new HttpEntity<>(reqObj, headers);
        logger.info("testPost(): " + request);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

}
