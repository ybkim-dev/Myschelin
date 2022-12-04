package project.myschelin.domain.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String redirectToDashboardPage() {
        return "redirect:/dashboard?userId=1";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@RequestParam(value = "userId") long userId, Model model) {
        model.addAttribute("userId", userId);
        return "main/dashboard";
    }
}
