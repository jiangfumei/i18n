package com.example.i18n.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.annotation.Resource;
import java.util.Locale;

public abstract class BasicController {

    @Resource
    private MessageSource messageSource;

    protected MessageSource getMessageSource() {
        return messageSource;
    }

    public String i18n(String code, Object... args) throws NoSuchMessageException {
        //RequestContextUtils.getLocale(request);//根据Request请求的语言来决定国际化
        Locale locale = LocaleContextHolder.getLocale();//如果是根据应用部署的服务器系统来决定国际化
        return messageSource.getMessage(code, args, locale);
    }
}
