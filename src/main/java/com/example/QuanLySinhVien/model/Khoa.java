package com.example.QuanLySinhVien.model;


import javax.persistence.*;

@Entity
@Table(name = "Khoa")
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false)
    Integer id;


    @Column(name = "Tenkhoa", nullable = false)
    String tenkhoa;

    @Column(name = "ten_lop", nullable = false)
    String tenLop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
}
