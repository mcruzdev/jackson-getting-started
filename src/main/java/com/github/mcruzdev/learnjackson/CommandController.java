package com.github.mcruzdev.learnjackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/commands")
public class CommandController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${legacy.system.url}")
    private String legacySystemUrl;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<String> get(@Valid CommandRequest commandRequest) throws JsonProcessingException {

        ResponseEntity<CommandResponse> response =
            restTemplate.postForEntity(legacySystemUrl.concat("/Legacy_Get"), commandRequest, CommandResponse.class);

        CommandResponse responseBody = response.getBody();

        String responseAsString = objectMapper.writeValueAsString(responseBody);

        return ResponseEntity.ok(responseAsString);
    }
}
