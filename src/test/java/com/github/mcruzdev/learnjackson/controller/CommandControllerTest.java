package com.github.mcruzdev.learnjackson.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mcruzdev.learnjackson.CommandResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

import static java.util.Arrays.asList;

@SpringBootTest
@AutoConfigureMockMvc
public class CommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testing() throws Exception {

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("commandName", "STATUS");
        params.add("commandTarget", "ONE");

        CommandResponse commandResponse = new CommandResponse("STATUS", "ONE", asList("1"));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/commands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.commandResultPayload").isNotEmpty());
    }

}
