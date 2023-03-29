package com.igorhenss.jsonifier.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public class Reader {

    public JsonNode read(JsonNode node, String key) {
        JsonNode value = node.get(key);
        if (!value.isNull()) {
            return value;
        }
        throw new RuntimeException();
    }

}
