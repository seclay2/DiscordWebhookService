package io.github.seclay2.webhookservice.controller;

import io.github.seclay2.webhookservice.model.DiscordRequest;
import io.github.seclay2.webhookservice.model.HnpRequest;
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
    public String testMethod() {
        return hnpRequestService.test();
    }


    @CrossOrigin
    @PostMapping("/convert")
    public String convertRequest(@RequestBody HnpRequest req) {
        DiscordRequest discordRequest = hnpRequestService.format(req);
        hnpRequestService.send(discordRequest);
        return discordRequest.toString();
    }

}
