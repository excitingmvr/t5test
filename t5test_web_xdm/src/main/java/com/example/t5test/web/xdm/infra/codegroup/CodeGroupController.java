package com.example.t5test.web.xdm.infra.codegroup;

import com.example.t5test.core.infra.codegroup.CodeGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/infra/codegroup/")
public class CodeGroupController {

    private final CodeGroupService service;

    @RequestMapping(value = "codeGroupList")
    public String codeGroupList(Model model) throws Exception{
            model.addAttribute("list", service.selectList());
        return "infra/codegroup/codeGroupList";
    }

}