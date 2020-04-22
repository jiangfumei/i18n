package com.example.i18n.controller;

import com.example.i18n.BasicMvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class I18nControllerTest extends BasicMvc {

    @Test
    public void message() throws Exception {
        mockMvc.perform(//
                get("/getMessage")//
                        //.header("Accept-Language", "zh_CN")
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE) )//
                .andDo(print())//
                .andExpect(status().isOk())//
                .andExpect(content().string("中文"))

        ;
        mockMvc.perform(//
                get("/getMessage")//
                        .header("Accept-Language", "zh")
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE) )//
                .andDo(print())//
                .andExpect(status().isOk())//
                .andExpect(content().string("chinese"))

        ;
        mockMvc.perform(//
                get("/getMessage")//
                        .header("Accept-Language", "ja"))//
                .andDo(print())//
                .andExpect(status().isOk())//
                .andExpect(content().string("あ"))

        ;
        mockMvc.perform(//
                get("/getMessage")//
                        .header("Accept-Language", "en"))//
                .andDo(print())//
                .andExpect(status().isOk())//
                .andExpect(content().string("english"))

        ;

    }
}