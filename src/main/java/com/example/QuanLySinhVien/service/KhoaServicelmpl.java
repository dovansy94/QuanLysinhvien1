package com.example.QuanLySinhVien.service;

import com.example.QuanLySinhVien.model.Khoa;
import com.example.QuanLySinhVien.repository.KhoaRepository;
import com.example.QuanLySinhVien.request.AddKhoaRequest;
import com.example.QuanLySinhVien.request.UpdateKhoaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaServicelmpl implements KhoaService {

    @Autowired
    KhoaRepository khoaRepository;


    @Override
    public boolean save(AddKhoaRequest addKhoaRequest) {
        try {
            Khoa khoa = new Khoa();
            khoa.setTenkhoa(addKhoaRequest.getTenkhoa());
            khoa.setTenLop(addKhoaRequest.getTenlop());
            khoaRepository.save(khoa);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean update(UpdateKhoaRequest updateKhoaRequest) {
        try {
            Khoa khoa = khoaRepository.findOne(updateKhoaRequest.getId());
            khoa.setTenLop(updateKhoaRequest.getTenlop());
            khoa.setTenkhoa(updateKhoaRequest.getTenkhoa());
            khoaRepository.save(khoa);
            return true;
        } catch (Exception e) {

            return false;
        }


    }

    @Override
    public boolean delete(int id){
        try{
            khoaRepository.delete(id);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Khoa> getAll() {
        return (List<Khoa>) khoaRepository.findAll();
    }

    @Override
    public boolean edit(int id) {
        try {
            Khoa khoa = khoaRepository.findOne(id);
            khoaRepository.save(khoa);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public Khoa findOne(int id){
        return khoaRepository.findOne(id);
    }
}

