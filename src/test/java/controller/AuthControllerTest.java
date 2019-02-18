package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    //    @Mock
    private AuthService authService = mock(AuthService.class);

    private AuthController authController = new AuthController(authService);

    @Before
    public void before() {
        when(authService.isAuthenticated(anyString(), anyString())).thenReturn(true);
        when(request.getSession()).thenReturn(session);

    }

    @Test
    public void authenticateTest() throws IOException {
        authController.authenticate(request, response, "any", "any");
        verify(authService, times(1)).isAuthenticated(anyString(), anyString());
        verify(request, times(2)).getSession();
        verify(session, times(2)).setAttribute(anyString(), any());
        verify(response).sendRedirect(anyString());

        when(authService.isAuthenticated(anyString(), anyString())).thenReturn(false);
        authController.authenticate(request, response, "any", "any");
        verify(authService, times(2)).isAuthenticated(anyString(), anyString());
        verify(request, times(2)).getSession();
        verify(session, times(2)).setAttribute(anyString(), any());
        verify(response, times(2)).sendRedirect(anyString());
    }

    @Test
    public void authPageTest() {
        ModelAndView answer = authController.authPage();
        assertNotNull(answer);
        assertEquals("auth", answer.getViewName());
        assertEquals(0, answer.getModel().size());
    }

}
