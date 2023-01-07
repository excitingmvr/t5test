package com.example.t5test.web.xdm.infra.codegroup;

import com.example.t5test.core.common.util.UtilDateTime;
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

    public void setSearch(CodeGroupVo vo){
        vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
        vo.setShOptionDate(vo.getShOptionDate() == null ? null : vo.getShOptionDate());
        vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
        vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

//		vo.setShOptionDate(vo.getShOptionDate() == null ? 1 : vo.getShOptionDate());
//		vo.setShDateStart(vo.getShDateStart() == null
//		    ? UtilDateTime.calculateDayString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
//		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null
//		    ? UtilDateTime.nowString()
//		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));
    }
    @RequestMapping(value = "/codeGroupList")
    public String codeGroupList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
            vo.setParamsPaging(service.selectOneCount(vo));
            model.addAttribute("list", service.selectList(vo));
        return "infra/codegroup/codeGroupList";
    }
    @RequestMapping(value= "/codeGroupForm")
    public String codeGroupForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws  Exception {
        model.addAttribute("item", service.selectOne(vo));
        return "infra/codegroup/codeGroupForm";
    }
    @RequestMapping(value= "/codeGroupInst")
    public String codeGroupInst(@ModelAttribute("vo") CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws  Exception {
        service.insert(dto);
        vo.setIfcgSeq(dto.getIfcgSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/codegroup/codeGroupForm";
    }
    @RequestMapping(value= "/codeGroupUpdt")
    public String codeGroupUpdt(@ModelAttribute("vo") CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws Exception {
        service.update(dto);
        vo.setIfcgSeq(dto.getIfcgSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/codegroup/codeGroupForm";
    }
    @RequestMapping(value= "/codeGroupUele")
    public String codeGroupUele(CodeGroupDto dto) throws  Exception {
        service.uelete(dto);
        return "redirect:/infra/codegroup/codeGroupList";
    }
    @RequestMapping(value = "codeGroupMultiUele")
    public String codeGroupMultiUele(CodeGroupDto dto, CodeGroupVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            dto.setIfcgSeq(checkboxSeq);
            service.uelete(dto);
        }
        return "redirect:/infra/codegroup/codeGroupList";
    }
    @RequestMapping(value= "/codeGroupDele")
    public String codeGroupDele(CodeGroupVo vo) throws  Exception {
        service.delete(vo);
        return "redirect:/infra/codegroup/codeGroupList";
    }
    @RequestMapping(value = "codeGroupMultiDele")
    public String codeGroupMultiDele(CodeGroupVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            vo.setIfcgSeq(checkboxSeq);
            service.delete(vo);
        }
        return "redirect:/infra/codegroup/codeGroupList";
    }

}