package com.igorhenss.jsonifier.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class TranslationRequest {

    private Map<String, String> mappings;
    private JsonNode content;

    public String getContentValueFromKey(String key) {
        JsonNode gotten = content.get(key);
        if (!gotten.isNull()) {
            return gotten.toPrettyString();
        }
        throw new RuntimeException();
    }

}