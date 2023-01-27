package com.example.t5test.web.xdm.infra.auth;

import com.example.t5test.core.common.util.UtilDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.t5test.core.infra.auth.AuthService;
import com.example.t5test.core.infra.auth.AuthDto;
import com.example.t5test.core.infra.auth.AuthVo;
import com.example.t5test.core.infra.menu.MenuService;
import com.example.t5test.core.infra.menu.MenuVo;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/infra/auth")
public class AuthController {

    private final AuthService service;
    private final MenuService mService;
    public void setSearch(AuthVo vo){
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
    @RequestMapping(value = "/authList")
    public String authList(@ModelAttribute("vo") AuthVo vo, Model model) throws Exception{
        vo.setParamsPaging(service.selectOneCount(vo));
        model.addAttribute("list", service.selectList(vo));

        return "infra/auth/authList";
    }
    @RequestMapping(value = "/authAjaxList")
    public String authAjaxList(@ModelAttribute("vo") AuthVo vo, Model model) throws Exception{
        return "infra/auth/authAjaxList";
    }

    @RequestMapping(value = "/authAjaxLita")
    public String authLita(@ModelAttribute("vo") AuthVo vo, Model model) throws Exception{
        vo.setParamsPaging(service.selectOneCount(vo));
        model.addAttribute("list", service.selectList(vo));
        return "infra/auth/authAjaxLita";
    }
    @RequestMapping(value= "/authForm")
    public String authForm(@ModelAttribute("vo") AuthVo vo, Model model) throws Exception {
        model.addAttribute("item", service.selectOne(vo));
        model.addAttribute("menuList", mService.selectList(new MenuVo()));
        return "infra/auth/authForm";
    }

    @RequestMapping(value= "/authInst")
    public String authInst(@ModelAttribute("vo") AuthVo vo, AuthDto dto, RedirectAttributes redirectAttributes) throws  Exception {
        service.insert(dto);
        vo.setIfatSeq(dto.getIfatSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/auth/authForm";
    }
    @RequestMapping(value= "/authUpdt")
    public String authUpdt(@ModelAttribute("vo") AuthVo vo, AuthDto dto, RedirectAttributes redirectAttributes) throws Exception {
        service.update(dto);
        vo.setIfatSeq(dto.getIfatSeq());
        redirectAttributes.addFlashAttribute("vo", vo);
        return "redirect:/infra/auth/authForm";
    }
    @RequestMapping(value= "/authUele")
    public String authUele(AuthDto dto) throws  Exception {
        service.uelete(dto);
        return "redirect:/infra/auth/authList";
    }
    @RequestMapping(value = "authMultiUele")
    public String codeMultiUele(AuthDto dto, AuthVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            dto.setIfatSeq(checkboxSeq);
            service.uelete(dto);
        }
        return "redirect:/infra/auth/authList";
    }
    @RequestMapping(value= "/authDele")
    public String authDele(AuthVo vo) throws  Exception {
        service.delete(vo);
        return "redirect:/infra/auth/authList";
    }
    @RequestMapping(value = "authMultiDele")
    public String authMultiDele(AuthVo vo) throws Exception {
        for (String checkboxSeq : vo.getCheckboxSeqArray()) {
            vo.setIfatSeq(checkboxSeq);
            service.delete(vo);
        }
        return "redirect:/infra/auth/authList";
    }

}