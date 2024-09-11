package org.example.rest_task.model;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private static final String REQUEST_PARAM_USER_NAME = "userName";
    private static final String REQUEST_PARAM_USER_PASSWORD = "userPassword";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String userName = webRequest.getParameter(REQUEST_PARAM_USER_NAME);
        String userPassword = webRequest.getParameter(REQUEST_PARAM_USER_PASSWORD);
        return new User(userName, userPassword);
    }
}
