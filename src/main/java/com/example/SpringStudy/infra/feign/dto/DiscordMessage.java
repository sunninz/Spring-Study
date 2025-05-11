package com.example.SpringStudy.infra.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscordMessage {

    private String content;
    private List<Embed> embeds;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Embed{
        private String title;
        private String description;
    }

}
