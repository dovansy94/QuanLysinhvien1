package com.example.QuanLySinhVien.request;

public class UpdateKhoaRequest {
    Integer Id;
    String Tenkhoa;
    String Tenlop;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenkhoa() {
        return Tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        Tenkhoa = tenkhoa;
    }

    public String getTenlop() {
        return Tenlop;
    }

    public void setTenlop(String tenlop) {
        Tenlop = tenlop;
    }

    public UpdateKhoaRequest() {
    }
}
