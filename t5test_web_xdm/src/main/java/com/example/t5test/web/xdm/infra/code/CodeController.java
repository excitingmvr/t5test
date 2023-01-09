package com.example.t5test.web.xdm.infra.code;

import com.example.t5test.core.infra.code.CodeService;
import com.example.t5test.core.infra.code.CodeVo;
import com.example.t5test.core.infra.code.CodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/infra/code")
public class CodeController {

    private final CodeService service;

    @RequestMapping(value = "/codeList")
    public String codeList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
            vo.setParamsPaging(service.selectOneCount(vo));
            model.addAttribute("list", service.selectList(vo));

        return "infra/code/codeList";
    }
    @RequestMapping(value= "/codeForm")
    public String codeForm(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
            model.addAttribute("item", service.selectOne(vo));
            model.addAttribute("list", service.selectListWithoutPaging());
        return "infra/code/codeForm";
    }

    @RequestMapping(value= "/insert")
    public String codeInst(@ModelAttribute("vo") CodeVo vo, CodeDto dto, RedirectAttributes redirectAttributes) throws  Exception {
        service.insert(dto);
        vo.setIfcdSeq(dto.getIfcdSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/code/form";
    }
    @RequestMapping(value= "/update")
    public String codeUpdt(@ModelAttribute("vo") CodeVo vo, CodeDto dto, RedirectAttributes redirectAttributes) throws Exception {
        service.update(dto);
        vo.setIfcdSeq(dto.getIfcdSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/code/form";
    }
    @RequestMapping(value= "/uelete")
    public String codeUele(CodeDto dto) throws  Exception {
        service.uelete(dto);
        return "redirect:/infra/codegroup/list";
    }
    @RequestMapping(value = "codeMultiUele")
    public String codeMultiUele(CodeDto dto, CodeVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            dto.setIfcdSeq(checkboxSeq);
            service.uelete(dto);
        }
        return "redirect:/infra/code/list";
    }
    @RequestMapping(value= "/delete")
    public String codeDele(CodeVo vo) throws  Exception {
        service.delete(vo);
        return "redirect:/infra/code/list";
    }
    @RequestMapping(value = "codeMultiDele")
    public String codeMultiDele(CodeVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            vo.setIfcdSeq(checkboxSeq);
            service.delete(vo);
        }
        return "redirect:/infra/code/list";
    }

}