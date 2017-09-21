package com.example.QuanLySinhVien.request;

import javax.validation.constraints.NotNull;

public class AddStudentRequest {


  String TenSV;
  String TenLop;
  String Diachi;
  String NgaySinh;
  boolean GioiTinh;

  public String getTenSV() {
    return TenSV;
  }

  public void setTenSV(String tenSV) {
    TenSV = tenSV;
  }

  public String getTenLop() {
    return TenLop;
  }

  public void setTenLop(String tenLop) {
    TenLop = tenLop;
  }

  public String getDiachi() {
    return Diachi;
  }

  public void setDiachi(String diachi) {
    Diachi = diachi;
  }

  public String getNgaySinh() {
    return NgaySinh;
  }

  public void setNgaySinh(String ngaySinh) {
    NgaySinh = ngaySinh;
  }

  public boolean isGioiTinh() {
    return GioiTinh;
  }

  public void setGioiTinh(boolean gioiTinh) {
    GioiTinh = gioiTinh;
  }

  public AddStudentRequest() {
  }
}


