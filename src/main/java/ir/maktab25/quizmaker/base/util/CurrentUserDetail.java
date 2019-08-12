package ir.maktab25.quizmaker.base.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserDetail {

    private CurrentUserDetail() {

    }

    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
