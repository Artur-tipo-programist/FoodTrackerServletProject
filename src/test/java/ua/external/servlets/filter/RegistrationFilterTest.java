package ua.external.servlets.filter;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static ua.external.servlets.util.cоnst.JspConst.PARAM_LOGIN;
import static ua.external.servlets.util.cоnst.SessionConst.SESSION_EXIST_USER;

public class RegistrationFilterTest {
    private static final String LOGIN_PARAM = "yulia.tokan.11@gmail.com";
    private static final String NEW_LOGIN_PARAM = "new.mail@gmail.com";
    private static final String PASSWORD_PARAM = "qwe12345";

    HttpServletResponse response;
    HttpServletRequest request;
    HttpSession session;
    FilterChain chain;
    RegistrationFilter filter;

    @Before
    public void setUp(){
        response = mock(HttpServletResponse.class);
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        chain = mock(FilterChain.class);

        filter = new RegistrationFilter();
    }

    @Test
    public void doFilterExistUser() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(SESSION_EXIST_USER)).thenReturn(true);
        when(request.getParameter(PARAM_LOGIN)).thenReturn(anyString());
        filter.doFilter(request, response, chain);

        verify(chain, times(0)).doFilter(request, response);
    }

    @Test
    public void doFilterNewUser() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(SESSION_EXIST_USER)).thenReturn(false);
        when(request.getParameter(PARAM_LOGIN)).thenReturn(NEW_LOGIN_PARAM);
        filter.doFilter(request, response, chain);

        verify(chain, times(1)).doFilter(request, response);
    }
}