package project.myschelin.domain.user.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/users/new")
    public String userCreatePage() {
        return "user/user-new";
    }
}
