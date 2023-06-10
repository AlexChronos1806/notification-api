package com.java.challenge.notificationapi.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import com.java.challenge.notificationapi.infra.ErrorDTO;
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
        RequestDTO requestDTO = createRequestDTO("SPORTS", "Testing message with category Sports to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        List<ResponseDTO> responseDTOS = objectMapper.readValue(responseAsString, new TypeReference<>() {});

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(3, responseDTOS.size());
        Assertions.assertEquals(3, responseDTOS.get(0).getNotifications().size());
        Assertions.assertEquals(3, responseDTOS.get(1).getNotifications().size());
        Assertions.assertEquals(3, responseDTOS.get(2).getNotifications().size());

        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(0).getNotifications().get(0).getMessage());
        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(0).getNotifications().get(1).getMessage());
        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(0).getNotifications().get(2).getMessage());

        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(1).getNotifications().get(0).getMessage());
        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(1).getNotifications().get(1).getMessage());
        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(1).getNotifications().get(2).getMessage());

        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(2).getNotifications().get(0).getMessage());
        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(2).getNotifications().get(1).getMessage());
        Assertions.assertEquals("Testing message with category Sports to send to all channels", responseDTOS.get(2).getNotifications().get(2).getMessage());
    }

    @Test
    void shouldSendRequestAndReturnResponseSuccessfullyWhenCategoryIsFilms() throws Exception {
        RequestDTO requestDTO = createRequestDTO("FILMS", "Testing message with category Films to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        List<ResponseDTO> responseDTOS = objectMapper.readValue(responseAsString, new TypeReference<>() {});

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(2, responseDTOS.size());
        Assertions.assertEquals(3, responseDTOS.get(0).getNotifications().size());
        Assertions.assertEquals(3, responseDTOS.get(1).getNotifications().size());

        Assertions.assertEquals("Testing message with category Films to send to all channels", responseDTOS.get(0).getNotifications().get(0).getMessage());
        Assertions.assertEquals("Testing message with category Films to send to all channels", responseDTOS.get(0).getNotifications().get(1).getMessage());
        Assertions.assertEquals("Testing message with category Films to send to all channels", responseDTOS.get(0).getNotifications().get(2).getMessage());

        Assertions.assertEquals("Testing message with category Films to send to all channels", responseDTOS.get(1).getNotifications().get(0).getMessage());
        Assertions.assertEquals("Testing message with category Films to send to all channels", responseDTOS.get(1).getNotifications().get(1).getMessage());
        Assertions.assertEquals("Testing message with category Films to send to all channels", responseDTOS.get(1).getNotifications().get(2).getMessage());
    }

    @Test
    void shouldSendRequestAndReturnResponseSuccessfullyWhenCategoryIsFinance() throws Exception {
        RequestDTO requestDTO = createRequestDTO("FINANCE", "Testing message with category Finance to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        List<ResponseDTO> responseDTOS = objectMapper.readValue(responseAsString, new TypeReference<>() {});

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(1, responseDTOS.size());
        Assertions.assertEquals(3, responseDTOS.get(0).getNotifications().size());

        Assertions.assertEquals("Testing message with category Finance to send to all channels", responseDTOS.get(0).getNotifications().get(0).getMessage());
        Assertions.assertEquals("Testing message with category Finance to send to all channels", responseDTOS.get(0).getNotifications().get(1).getMessage());
        Assertions.assertEquals("Testing message with category Finance to send to all channels", responseDTOS.get(0).getNotifications().get(2).getMessage());
    }

    @Test
    void shouldSendRequestAndReturnInvalidCategoryResponse() throws Exception {
        RequestDTO requestDTO = createRequestDTO("FINANCEE", "Testing message to send to all channels");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        ErrorDTO errorDTO = objectMapper.readValue(responseAsString, ErrorDTO.class);

        Assertions.assertNotNull(errorDTO);
        Assertions.assertEquals("Invalid category!", errorDTO.getMessage());
    }

    @Test
    void shouldSendRequestAndReturnInvalidMessageResponse() throws Exception {
        RequestDTO requestDTO = createRequestDTO("FINANCE", "");

        ResultActions resultActions = mockMvc.perform(post("/notifications")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest());

        String responseAsString = resultActions.andReturn().getResponse().getContentAsString();

        ErrorDTO errorDTO = objectMapper.readValue(responseAsString, ErrorDTO.class);

        Assertions.assertNotNull(errorDTO);
        Assertions.assertEquals("Invalid message!", errorDTO.getMessage());
    }

    private RequestDTO createRequestDTO(String category, String message) {
        return new RequestDTO.RequestDTOBuilder()
                .category(category)
                .message(message).build();

    }
}