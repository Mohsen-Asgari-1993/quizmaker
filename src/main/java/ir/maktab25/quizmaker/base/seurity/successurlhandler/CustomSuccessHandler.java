package ir.maktab25.quizmaker.base.seurity.successurlhandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        handle(request, response, authentication);
    }

    private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = determineTargetUrl(authentication);

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        boolean isAdmin = false;
        boolean isSuperUser = false;
        boolean isTeacher = false;
        boolean isStudent = false;
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        label:
        for (GrantedAuthority grantedAuthority : authorities) {
            switch (grantedAuthority.getAuthority()) {
                case "ADMIN": {
                    isAdmin = true;
                    break label;
                }
                case "TEACHER": {
                    isTeacher = true;
                    break label;
                }
                case "STUDENT": {
                    isStudent = true;
                    break label;
                }
                case "SUPER": {
                    isSuperUser = true;
                    break label;
                }
            }
        }

        if (isAdmin) {
            return "/redirect/admin/admin.html";
        } else if (isTeacher) {
            return "/redirect/teacher/teacher.html";
        } else if (isStudent) {
            return "/redirect/student/student.html";
        } else if (isSuperUser) {
            return "/swagger-ui.html";
        } else {
            throw new IllegalStateException();
        }
    }
}
