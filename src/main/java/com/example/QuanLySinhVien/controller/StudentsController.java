package com.example.QuanLySinhVien.controller;

import com.example.QuanLySinhVien.model.Student;
import com.example.QuanLySinhVien.request.AddStudentRequest;
import com.example.QuanLySinhVien.request.EditStudentRequest;
import com.example.QuanLySinhVien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentsController {

  @Autowired
  private StudentService studentService;

  @RequestMapping(value = {"", "/", "/student"})
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/student/add", method = RequestMethod.GET)
  public String addStudent() {
    return "student/add";
  }

  @RequestMapping(value = "/student/save", method = RequestMethod.POST)
  public String saveStudent(@Validated AddStudentRequest studentRequest,
      BindingResult bindingResult, RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("status", "Hãy nhập đủ các thông tin.");
      return "redirect:/student/add";
    }

    if (studentService.save(studentRequest)) {
      redirectAttributes.addFlashAttribute("status", "Đã lưu thành công.");
    } else {
      redirectAttributes.addFlashAttribute("status", "Không thể lưu.");
    }
    return "redirect:/student/add";
  }

  @RequestMapping(value = "/student/toEdit", method = RequestMethod.GET)
  public String editStudent(Model model, @RequestParam("id") String id) {
    model.addAttribute("student",studentService.findOne(Integer.parseInt(id)));
    return "student/edit";
  }

  @RequestMapping(value = "/student/edit", method = RequestMethod.POST)
  public String exditStudent(@Validated EditStudentRequest studentRequest,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("status", "Hãy nhập đủ các thông tin.");
      return "redirect:/student/getAll";
    }

    if (studentService.edit(studentRequest)) {
      redirectAttributes.addFlashAttribute("status", "Đã lưu thành công.");
    } else {
      redirectAttributes.addFlashAttribute("status", "Không thể lưu.");
    } {
    return "redirect:/student/getAll";}



}
  @RequestMapping(value = "/student/getAll", method = RequestMethod.GET)
  public String getAll(Model model){
    List<Student> tmp = studentService.getAll();
    model.addAttribute("StudentList",tmp);
    return "student/getAll";
  }

  @RequestMapping(value = "/student/delete", method = RequestMethod.GET)
  public String delete(@RequestParam("id") String id){
    studentService.delete(Integer.parseInt(id));
    return "redirect:getAll";
  }
}
