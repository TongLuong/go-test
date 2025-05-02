package com.gos.gos;

public class ScoreDto {
    public String sbd;
    public Double toan;
    public Double ngu_van;
    public Double ngoai_ngu;
    public Double vat_li;
    public Double hoa_hoc;
    public Double sinh_hoc;
    public Double lich_su;
    public Double dia_li;
    public Double gdcd;

    public ScoreDto() {}

    public ScoreDto(User user) {
        this.sbd = user.getSbd();
        this.toan = user.getToan();
        this.ngu_van = user.getNgu_van();
        this.ngoai_ngu = user.getNgoai_ngu();
        this.vat_li = user.getVat_li();
        this.hoa_hoc = user.getHoa_hoc();
        this.sinh_hoc = user.getSinh_hoc();
        this.lich_su = user.getLich_su();
        this.dia_li = user.getDia_li();
        this.gdcd = user.getGdcd();
    }
}
