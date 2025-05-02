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
    private Double toan;

    @Column(name = "ngu_van")
    private Double ngu_van;

    @Column(name = "ngoai_ngu")
    private Double ngoai_ngu;

    @Column(name = "vat_li")
    private Double vat_li;

    @Column(name = "hoa_hoc")
    private Double hoa_hoc;

    @Column(name = "sinh_hoc")
    private Double sinh_hoc;

    @Column(name = "lich_su")
    private Double lich_su;

    @Column(name = "dia_li")
    private Double dia_li;

    @Column(name = "gdcd")
    private Double gdcd;

    @Column(name = "ma_ngoai_ngu")
    private String ma_ngoai_ngu;
}
