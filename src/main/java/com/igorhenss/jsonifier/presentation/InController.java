package com.igorhenss.jsonifier.presentation;

import com.igorhenss.jsonifier.dto.TranslationRequest;
import com.igorhenss.jsonifier.service.Translator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class InController {

    private Translator translator;

    @PostMapping("/translate")
    public Map<String, String> translate(@RequestBody TranslationRequest body) {
        return translator.translate(body);
    }

}
