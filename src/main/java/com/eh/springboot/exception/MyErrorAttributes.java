package com.eh.springboot.exception;


import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;

import java.util.Map;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        // 默认返回的错误信息
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        // 添加自定义信息
        map.put("company", "cana");

        //我们的异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }

}
