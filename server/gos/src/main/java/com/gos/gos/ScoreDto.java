package com.gos.gos;

public class ScoreDto {
    public String sbd;
    public String toan;
    public String ngu_van;
    public String ngoai_ngu;
    public String vat_li;
    public String hoa_hoc;
    public String sinh_hoc;
    public String lich_su;
    public String dia_li;
    public String gdcd;

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
