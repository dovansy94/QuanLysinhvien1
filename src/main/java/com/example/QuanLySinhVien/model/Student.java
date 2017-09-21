package com.example.QuanLySinhVien.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false)
  Integer id;

  @Column(name = "TenSV", nullable = false)
  String ten;

  @Column(name = "TenLop", nullable = false)
  String TenLop;
  @Column(name = "Diachi", nullable = false)
  String Diachi;
  @Column(name = "NgaySinh", nullable = false)
  String NgaySinh;
  @Column(name = "GioiTinh", nullable = false)
  Boolean gioitinh;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public Boolean getGioitinh() {
    return gioitinh;
  }

  public void setGioitinh(Boolean gioitinh) {
    this.gioitinh = gioitinh;
  }

  public String getTenLop() {
    return TenLop;
  }

  public void setTenLop(String tenLop) {
    this.TenLop = tenLop;
  }

  public String getDiachi() {
    return Diachi;
  }

  public void setDiachi(String diachi) {
   this.Diachi = diachi;
  }

  public String getNgaySinh() {
    return NgaySinh;
  }

  public void setNgaySinh(String ngaySinh) {
   this.NgaySinh = ngaySinh;
  }


}
