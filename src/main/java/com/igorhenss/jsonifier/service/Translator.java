package com.igorhenss.jsonifier.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.igorhenss.jsonifier.dto.TranslationRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class Translator {

    public Map<String, String> translate(TranslationRequest request) {
        Map<String, String> mappings = request.getMappings();
        Map<String, String> newContent = new HashMap<>();
        mappings.forEach(mapToJson(request, newContent));
        return newContent;
    }

    private BiConsumer<String, String> mapToJson(TranslationRequest request, Map<String, String> newContent) {
        return (fromKey, toKey) -> {
            String node = request.getContentValueFromKey(fromKey);
            newContent.putIfAbsent(toKey, node);
        };
    }

}
