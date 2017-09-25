package com.example.QuanLySinhVien.service;

import com.example.QuanLySinhVien.request.AddStudentRequest;
import com.example.QuanLySinhVien.request.EditStudentRequest;
import com.example.QuanLySinhVien.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

  boolean save(AddStudentRequest addStudentRequest);
  boolean edit(EditStudentRequest addStudentRequest);
  List<Student> getAll();
  boolean delete(int id);
  boolean update(int id);
  Student findOne(int id);
}
