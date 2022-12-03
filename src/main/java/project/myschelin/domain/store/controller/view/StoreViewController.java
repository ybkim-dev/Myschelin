package project.myschelin.domain.store.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StoreViewController {

    @GetMapping("/admin/stores")
    public String storesPage() {
        return "admin/stores";
    }

    @GetMapping("/admin/stores/{storeId}")
    public String storeDetailPage(@PathVariable("storeId") long storeId, Model model) {
        model.addAttribute("storeId", storeId);
        return "admin/store-detail";
    }

    @GetMapping("/admin/stores/edit/{storeId}")
    public String storeEditPage(@PathVariable("storeId") long storeId, Model model) {
        model.addAttribute("storeId", storeId);
        return "admin/store-modify";
    }

    @GetMapping("/admin/stores/new")
    public String storeCreatePage() {
        return "admin/store-new";
    }
}
