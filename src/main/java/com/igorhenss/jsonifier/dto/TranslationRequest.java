package com.igorhenss.jsonifier.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.igorhenss.jsonifier.service.JsonifierMapper;
import lombok.Getter;

import java.util.Map;

@Getter
public class TranslationRequest {

    private final Map<String, String> mappings;
    private final JsonNode content;

    @JsonCreator
    public TranslationRequest(
        @JsonProperty String mappings,
        @JsonProperty String content
    ) {
        this.mappings = JsonifierMapper.fromStringToMap(mappings);
        this.content = JsonifierMapper.fromStringToNode(content);
    }

}
