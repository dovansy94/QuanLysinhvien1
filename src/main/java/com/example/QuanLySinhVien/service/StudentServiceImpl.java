package com.example.QuanLySinhVien.service;

import com.example.QuanLySinhVien.model.Student;
import com.example.QuanLySinhVien.repository.StudentRepository;
import com.example.QuanLySinhVien.request.EditStudentRequest;
import com.example.QuanLySinhVien.request.AddStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public boolean save(AddStudentRequest addStudentRequest) {
    try {
      Student student = new Student();
      student.setTen(addStudentRequest.getTenSV());
      student.setTenLop(addStudentRequest.getTenLop());
      student.setDiachi(addStudentRequest.getDiachi());
      student.setNgaySinh(addStudentRequest.getNgaySinh());
      student.setGioitinh(addStudentRequest.isGioiTinh());
      studentRepository.save(student);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean edit (EditStudentRequest editStudentRequest) {

    try {
      Student student = new Student();
      student.setTen(editStudentRequest.getTenSV());
      student.setTenLop(editStudentRequest.getTenLop());
      student.setDiachi(editStudentRequest.getDiachi());
      student.setNgaySinh(editStudentRequest.getNgaySinh());
      studentRepository.save(student);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public List<Student> getAll(){
    return (List<Student>) studentRepository.findAll();
  }

  @Override
  public boolean delete(int id){
    try{
      studentRepository.delete(id);
      return true;
    } catch (Exception ex){
      ex.printStackTrace();
      return false;
    }
  }
}
