package com.example.t5test.web.xdm.infra.menu;

import com.example.t5test.core.common.util.UtilDateTime;

import com.example.t5test.core.infra.menu.MenuDto;
import com.example.t5test.core.infra.menu.MenuService;
import com.example.t5test.core.infra.menu.MenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/infra/menu")
public class MenuController {

    private final MenuService service;

    public void setSearch(MenuVo vo){
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
    @RequestMapping(value = "/menuList")
    public String menuList(@ModelAttribute("vo") MenuVo vo, Model model) throws Exception{
        vo.setParamsPaging(service.selectOneCount(vo));
        model.addAttribute("list", service.selectList(vo));
        return "infra/menu/menuList";
    }

    @RequestMapping(value = "/menuAjaxList")
    public String menuAjaxList(@ModelAttribute("vo") MenuVo vo, Model model) throws Exception{
        return "infra/menu/menuAjaxList";
    }

    @RequestMapping(value = "/menuAjaxLita")
    public String menuLita(@ModelAttribute("vo") MenuVo vo, Model model) throws Exception{
            vo.setParamsPaging(service.selectOneCount(vo));
            model.addAttribute("list", service.selectList(vo));
        return "infra/menu/menuAjaxLita";
    }
    @RequestMapping(value= "/menuForm")
    public String menuForm(@ModelAttribute("vo") MenuVo vo, Model model) throws  Exception {
        model.addAttribute("item", service.selectOne(vo));
        return "infra/menu/menuForm";
    }
    @RequestMapping(value= "/menuInst")
    public String menuInst(@ModelAttribute("vo") MenuVo vo, MenuDto dto, RedirectAttributes redirectAttributes) throws  Exception {
        service.insert(dto);
        vo.setIfmuSeq(dto.getIfmuSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/menu/menuForm";
    }
    @RequestMapping(value= "/menuUpdt")
    public String menuUpdt(@ModelAttribute("vo") MenuVo vo, MenuDto dto, RedirectAttributes redirectAttributes) throws Exception {
        service.update(dto);
        vo.setIfmuSeq(dto.getIfmuSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/menu/cmenuForm";
    }
    @RequestMapping(value= "/menuUele")
    public String menuUele(MenuDto dto) throws  Exception {
        service.uelete(dto);
        return "redirect:/infra/menu/menuList";
    }
    @RequestMapping(value = "/menuMultiUele")
    public String menuMultiUele(MenuDto dto, MenuVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            dto.setIfmuSeq(checkboxSeq);
            service.uelete(dto);
        }
        return "redirect:/infra/menu/menuList";
    }
    @RequestMapping(value= "/menuDele")
    public String menuDele(MenuVo vo) throws  Exception {
        service.delete(vo);
        return "redirect:/infra/menu/menuList";
    }
    @RequestMapping(value = "/menuMultiDele")
    public String menuMultiDele(MenuVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            vo.setIfmuSeq(checkboxSeq);
            service.delete(vo);
        }
        return "redirect:/infra/menu/menuList";
    }

}