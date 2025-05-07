package org.example.subService.controller;

import org.example.subService.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/subscriptions")
public class SubscribeController {

    SubscribeService subscribeService;
    @Autowired
    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @GetMapping("/top")
    public String top(Model model){
        model.addAttribute("subscribeTopList",subscribeService.getTop3List() );
        return "top";
    }
}
