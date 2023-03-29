package com.igorhenss.jsonifier.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.igorhenss.jsonifier.dto.TranslationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
@AllArgsConstructor
public class Translator {

    private Reader reader;

    public JsonNode mapKeyToResultJson(TranslationRequest request) {
        ObjectNode resultantJson = JsonNodeFactory.instance.objectNode();
        request.getMappings().forEach(mapKeyToResultJson(request.getContent(), resultantJson));
        return resultantJson;
    }

    private BiConsumer<String, String> mapKeyToResultJson(JsonNode originalJson, ObjectNode resultantJson) {
        return (fromKey, toKey) -> {
            JsonNode readValue = readValueFromKey(originalJson, fromKey);
            resultantJson.putIfAbsent(toKey, readValue);
        };
    }

    private JsonNode readValueFromKey(JsonNode node, String key) {
        return reader.read(node, key);
    }

}
