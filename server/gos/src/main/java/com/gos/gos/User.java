package com.gos.gos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter @Setter
public class User {
    @Id
    @Column(name = "sbd")
    private String sbd;

    @Column(name = "toan")
    private String toan;

    @Column(name = "ngu_van")
    private String ngu_van;

    @Column(name = "ngoai_ngu")
    private String ngoai_ngu;

    @Column(name = "vat_li")
    private String vat_li;

    @Column(name = "hoa_hoc")
    private String hoa_hoc;

    @Column(name = "sinh_hoc")
    private String sinh_hoc;

    @Column(name = "lich_su")
    private String lich_su;

    @Column(name = "dia_li")
    private String dia_li;

    @Column(name = "gdcd")
    private String gdcd;

    @Column(name = "ma_ngoai_ngu")
    private String ma_ngoai_ngu;
}
