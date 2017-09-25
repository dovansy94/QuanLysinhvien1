package com.example.QuanLySinhVien.service;


import com.example.QuanLySinhVien.request.AddKhoaRequest;
import com.example.QuanLySinhVien.model.Khoa;
import com.example.QuanLySinhVien.request.UpdateKhoaRequest;

import java.util.List;


public interface KhoaService {
   boolean save(AddKhoaRequest addKhoaRequest);
   boolean update(UpdateKhoaRequest updateKhoaRequest);

    List<Khoa> getAll();
    boolean delete(int id);
    boolean edit(int id);
    Khoa findOne(int id);
}
