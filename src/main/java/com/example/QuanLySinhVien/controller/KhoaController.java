package com.example.QuanLySinhVien.controller;

import com.example.QuanLySinhVien.request.AddKhoaRequest;
import com.example.QuanLySinhVien.request.UpdateKhoaRequest;
import com.example.QuanLySinhVien.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    @RequestMapping(value = {"", "/", "/khoa"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/khoa/add", method = RequestMethod.GET)
    public String saveKhoa() {
        return "khoa/add";
    }

    @RequestMapping(value = "/khoa/save", method = RequestMethod.POST)
    public String saveKhoa(@Validated AddKhoaRequest khoaRequest,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("status", "Hãy nhập đủ các thông tin.");
            return "redirect:/khoa/add";
        }

        if (khoaService.save(khoaRequest)) {
            redirectAttributes.addFlashAttribute("status", "Đã lưu thành công.");
        } else {
            redirectAttributes.addFlashAttribute("status", "Không thể lưu.");
        }
        return "redirect:/khoa/add";
    }
    @RequestMapping(value = "/khoa/update", method = RequestMethod.GET)
    public String updateKhoa() {
        return "khoa/update";
    }
    @RequestMapping(value = "/khoa/update", method = RequestMethod.POST)
    public String updatekhoa(@Validated UpdateKhoaRequest khoaRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (khoaService.update(khoaRequest)){
            redirectAttributes.addFlashAttribute("status", "đã lưu thành công");

        }else {
            redirectAttributes.addFlashAttribute("status", "khong thể lưu");
        }
        return "redirect:/khoa/update";
    }

    @RequestMapping(value = "/khoa/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id){
       khoaService.delete(Integer.parseInt(id));
        return "redirect:getAll";
    }

    @RequestMapping(value = "/khoa/getAll", method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("KhoaList",khoaService.getAll());
        return "/khoa/getAll";
    }

}
