package com.gos.gos;

public class ScoreDto {
    public String sbd;
    public String diem_toan;
    public String diem_ngu_van;
    public String diem_ngoai_ngu;
    public String diem_vat_li;
    public String diem_hoa_hoc;
    public String diem_sinh_hoc;
    public String diem_lich_su;
    public String diem_dia_li;
    public String diem_gdcd;

    public ScoreDto() {}

    public ScoreDto(User user) {
        this.sbd = user.getSbd();
        this.diem_toan = user.getToan();
        this.diem_ngu_van = user.getNgu_van();
        this.diem_ngoai_ngu = user.getNgoai_ngu();
        this.diem_vat_li = user.getVat_li();
        this.diem_hoa_hoc = user.getHoa_hoc();
        this.diem_sinh_hoc = user.getSinh_hoc();
        this.diem_lich_su = user.getLich_su();
        this.diem_dia_li = user.getDia_li();
        this.diem_gdcd = user.getGdcd();
    }
}
