package com.example.t5test.web.xdm.infra.codegroup;

import com.example.t5test.core.infra.codegroup.CodeGroupDto;
import com.example.t5test.core.infra.codegroup.CodeGroupService;
import com.example.t5test.core.infra.codegroup.CodeGroupVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/infra/codegroup")
public class CodeGroupController {

    private final CodeGroupService service;

    @RequestMapping(value = "/codeGroupList")
    public String codeGroupList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
            vo.setParamsPaging(service.selectOneCount(vo));
            model.addAttribute("list", service.selectList(vo));
        return "infra/codegroup/codeGroupList";
    }
    @RequestMapping(value= "/codeGroupForm")
    public String CodeGroupForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws  Exception {
        model.addAttribute("item", service.selectOne(vo));
        return "infra/codegroup/codeGroupForm";
    }
    @RequestMapping(value= "/insert")
    public String CodeGroupInst(@ModelAttribute("vo") CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws  Exception {
        service.insert(dto);
        vo.setIfcgSeq(dto.getIfcgSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/codegroup/form";
    }
    @RequestMapping(value= "/update")
    public String CodeGroupUpdt(@ModelAttribute("vo") CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws Exception {
        service.update(dto);
        vo.setIfcgSeq(dto.getIfcgSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/codegroup/form";
    }
    @RequestMapping(value= "/uelete")
    public String CodeGroupUele(CodeGroupDto dto) throws  Exception {
        service.uelete(dto);
        return "redirect:/infra/codegroup/list";
    }
    @RequestMapping(value = "codeGroupMultiUele")
    public String codeGroupMultiUele(CodeGroupDto dto, CodeGroupVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            dto.setIfcgSeq(checkboxSeq);
            service.uelete(dto);
        }
        return "redirect:/infra/codegroup/list";
    }
    @RequestMapping(value= "/delete")
    public String CodeGroupDele(CodeGroupVo vo) throws  Exception {
        service.delete(vo);
        return "redirect:/infra/codegroup/list";
    }
    @RequestMapping(value = "codeGroupMultiDele")
    public String codeGroupMultiDele(CodeGroupVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            vo.setIfcgSeq(checkboxSeq);
            service.delete(vo);
        }
        return "redirect:/infra/codegroup/list";
    }

}