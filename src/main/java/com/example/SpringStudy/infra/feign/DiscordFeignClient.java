package com.example.SpringStudy.infra.feign;

import com.example.SpringStudy.infra.feign.dto.DiscordMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${discord.name}", url = "${discord.webhook-url}")
public interface DiscordFeignClient {

    @PostMapping
    void sendMessage(@RequestBody DiscordMessage discordMessage);
}
