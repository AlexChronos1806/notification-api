package com.java.challenge.notificationapi.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NotificationResourceTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void shouldSendRequestAndReturnResponseSuccessfullyWhenCategoryIsSports() throws Exception {
        RequestDTO requestDTO = createRequestDTO("SPORTS", "Testing message to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        List<ResponseDTO> responseDTOS = objectMapper.readValue(responseAsString, new TypeReference<>() {});

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(3, responseDTOS.size());
    }

    @Test
    void shouldSendRequestAndReturnResponseSuccessfullyWhenCategoryIsFilms() throws Exception {
        RequestDTO requestDTO = createRequestDTO("FILMS", "Testing message to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        List<ResponseDTO> responseDTOS = objectMapper.readValue(responseAsString, new TypeReference<>() {});

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(2, responseDTOS.size());
    }

    @Test
    void shouldSendRequestAndReturnResponseSuccessfullyWhenCategoryIsFinance() throws Exception {
        RequestDTO requestDTO = createRequestDTO("FINANCE", "Testing message to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        List<ResponseDTO> responseDTOS = objectMapper.readValue(responseAsString, new TypeReference<>() {});

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(1, responseDTOS.size());
    }

    private RequestDTO createRequestDTO(String category, String message) {
        return new RequestDTO.RequestDTOBuilder()
                .category(category)
                .message(message).build();

    }
}