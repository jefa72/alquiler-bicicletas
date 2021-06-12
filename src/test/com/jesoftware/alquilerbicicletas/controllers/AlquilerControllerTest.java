package com.jesoftware.alquilerbicicletas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesoftware.alquilerbicicletas.resources.AlquilerResource;
import com.jesoftware.alquilerbicicletas.service.AlquilerService;
import com.jesoftware.alquilerbicicletas.utils.AlquilerUtil;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlquilerController.class)
class AlquilerControllerTest {

    @Autowired
    private MockMvc mvc ;

    @MockBean
    private AlquilerService alquilerService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void whenValidInput_return200() throws Exception{
        //Valida serialización de la entrada
        AlquilerResource alquilerResource = AlquilerUtil.buildIvalidAlquilerResource();
        mvc.perform(post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(alquilerResource))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidInput_mapsToBusinessCall() throws Exception{
        //valida llamado a la lógica de negocio
        AlquilerResource alquilerResource = AlquilerUtil.buildAlquilerResource();
        mvc.perform(post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(alquilerResource))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ArgumentCaptor<AlquilerResource> alquilerResourceCaptor = ArgumentCaptor.forClass(AlquilerResource.class);
        verify(alquilerService, times(1)).saveAlquiler(alquilerResourceCaptor.capture());
        assertThat(alquilerResourceCaptor.getValue().getFechaAlquilerStr(), is(equalTo(AlquilerUtil.fechaAlquiler)));
    }

    @Test
    void saveValidAlquilerTest() throws Exception{
        AlquilerResource alquilerResource = AlquilerUtil.buildAlquilerResource();
        when(alquilerService.saveAlquiler(any())).thenReturn(alquilerResource);
        MvcResult mvcResult = mvc.perform(post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(alquilerResource))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();//valida serialización de la salida

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        String expectedResponseBody = mapper.writeValueAsString(alquilerResource);
        assertThat(actualResponseBody, is(equalTo(expectedResponseBody)));
    }

    @Test
    void saveInvalidAlquilerTest() throws Exception{
        //verifica validación de la entrada
        AlquilerResource ivalidAlquilerResource = AlquilerUtil.buildIvalidAlquilerResource();
        MvcResult mvcResult = mvc.perform(post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(ivalidAlquilerResource))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        BadRequestExceptionHandler.ErrorResult expectedErrorResponse = new BadRequestExceptionHandler.ErrorResult("fechaAlquilerStr", "must not be blank");
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        String expectedResponseBody = mapper.writeValueAsString(expectedErrorResponse);
        assertThat(expectedResponseBody, is(equalTo(actualResponseBody)));
    }
}