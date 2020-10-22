package com.eh.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class I18NLocaleResolver implements LocaleResolver {

    private static final String PATH_PARAMETER_SPLIT = "_";


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = request.getLocale();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split(PATH_PARAMETER_SPLIT);
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
