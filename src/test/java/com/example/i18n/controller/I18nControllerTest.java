package com.example.i18n.controller;

import com.example.i18n.BasicMvc;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class I18nControllerTest extends BasicMvc {

    @Test
    public void message() throws Exception {
        String china = mockMvc.perform(//
                get("/getMessage")//
                        .header("Accept-Language", "zh")
                        .locale(Locale.CHINA)
                        )//
        .andReturn()
        .getResponse()
        .getContentAsString();
        System.out.println(china);

        String en = mockMvc.perform(//
                get("/getMessage")//
                        .header("Accept-Language", "en")
                        .locale(Locale.ENGLISH)
        )//
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(en);

        String ja = mockMvc.perform(//
                get("/getMessage")//
                        .header("Accept-Language", "ja")
                        .locale(Locale.JAPAN)
        )//
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(ja);

//        mockMvc.perform(//
//                get("/getMessage")//
//                        .header("Accept-Language", "en"))//
//                .andDo(print())//
//                .andExpect(status().isOk())//
//                .andExpect(content().string("english"))
//
//        ;

    }
}