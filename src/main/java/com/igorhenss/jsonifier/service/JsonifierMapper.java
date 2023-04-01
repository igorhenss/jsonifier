package com.igorhenss.jsonifier.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public final class JsonifierMapper {

    private static JsonifierMapper instance;

    private final ObjectMapper mapper;

    public static Map<String, String> fromStringToMap(String json) {
        JsonNode jsonNode = fromStringToNode(json);
        return getInstanceMapper().convertValue(jsonNode, new TypeReference<>(){});
    }

    @SneakyThrows
    public static JsonNode fromStringToNode(String json) {
        return getInstanceMapper().readTree(json);
    }

    private static ObjectMapper getInstanceMapper() {
        if (Objects.isNull(instance)) {
            instance = createSingletonInstance();
        }
        return instance.mapper;
    }

    private static JsonifierMapper createSingletonInstance() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new JsonifierMapper(mapper);
    }

}
