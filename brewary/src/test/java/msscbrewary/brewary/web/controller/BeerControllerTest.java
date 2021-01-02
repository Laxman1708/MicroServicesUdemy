package msscbrewary.brewary.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import msscbrewary.brewary.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getBeer() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/api/v1/beer"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder).andExpect(ok);
    }

    @Test
    void handlePost() throws Exception{
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJSON);
        ResultMatcher created = MockMvcResultMatchers.status()
                .isCreated();
        mockMvc.perform(builder).andExpect(created);
    }

    @Test
    void handleUpdate() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/api/v1/beer"+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON).content(beerDtoJSON);
        ResultMatcher updated = MockMvcResultMatchers.status()
                .isNoContent();
        mockMvc.perform(builder).andExpect(updated);
    }

    @Test
    void deleteBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .delete("/api/v1/beer"+ UUID.randomUUID().toString());
        ResultMatcher deleted = MockMvcResultMatchers.status()
                .isNoContent();
        mockMvc.perform(builder).andExpect(deleted);
    }
}