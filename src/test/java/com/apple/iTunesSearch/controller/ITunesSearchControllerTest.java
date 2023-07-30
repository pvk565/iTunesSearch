package com.apple.iTunesSearch.controller;

import com.apple.iTunesSearch.entity.ITune;
import com.apple.iTunesSearch.entity.ITunes;
import com.apple.iTunesSearch.service.ITuneSearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ITunesSearchContoller.class)
public class ITunesSearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ITuneSearchService iTuneSearchService;
    private ITune apple = ITune.builder()
            .id(1)
            .uid("TP40017632-CH3-SW1")
            .productDes("IPhone Supported")
            .productId("TP40017632-CH3-SW1")
            .productType("Audio")
            .productRef("Apple Store")
            .build();
    private ITunes appleTunes = ITunes.builder()
            .resultCount(1)
            .appleTunes(Arrays.asList(apple))
            .build();


    @Test
    public void getAllDetailsTest() throws  Exception{
        System.out.println(objectMapper.writeValueAsString(appleTunes));
        when(iTuneSearchService.getAllITunesDetails(any(ITunes.class))).thenReturn(appleTunes);
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders
                        .get("/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        assertThat(mockHttpServletResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(mockHttpServletResponse.getContentAsString()).isEqualTo(
                objectMapper.writeValueAsString(appleTunes));
        System.out.println(mockHttpServletResponse.getContentAsString()
                + "\t"+ objectMapper.writeValueAsString(appleTunes));
    }

    @Test
    public void getLimitedDetailsTest() throws  Exception{
        System.out.println(objectMapper.writeValueAsString(appleTunes));
        when(iTuneSearchService.getAllITunesDetails(any(ITunes.class))).thenReturn(appleTunes);
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders
                        .get("/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/all?")
                        .param("term","Audio")
                        .param("limit",String.valueOf(1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        assertThat(mockHttpServletResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(mockHttpServletResponse.getContentAsString()).isEqualTo(
                objectMapper.writeValueAsString(appleTunes));
        System.out.println(mockHttpServletResponse.getContentAsString()
                + "\t"+ objectMapper.writeValueAsString(appleTunes));
    }
}
