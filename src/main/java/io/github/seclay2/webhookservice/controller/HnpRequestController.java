package io.github.seclay2.webhookservice.controller;

import io.github.seclay2.webhookservice.model.discord.DiscordRequest;
import io.github.seclay2.webhookservice.model.hnp.HnpRequest;
import io.github.seclay2.webhookservice.service.HnpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hnp")
public class HnpRequestController {

    @Autowired
    private HnpRequestService hnpRequestService;

    @CrossOrigin
    @GetMapping("/test")
    public String testGetMethod() {
        return hnpRequestService.testGet();
    }

    @CrossOrigin
    @PostMapping("/test")
    public String testPostMethod() {
        return hnpRequestService.testPost();
    }

    @CrossOrigin
    @PostMapping("/convert")
    public String convertRequest(@RequestBody HnpRequest req) {
        DiscordRequest discordRequest = hnpRequestService.format(req);
        return hnpRequestService.send(discordRequest);
    }

}
