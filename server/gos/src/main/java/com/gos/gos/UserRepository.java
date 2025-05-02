package com.gos.gos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findBySbd(String sbd);

    @Query(
        value = """
            select count(u) from users u
            where u.toan <= ?1 and u.toan >= ?2
        """
    )
    Integer countByToan(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.ngu_van <= ?1 and u.ngu_van >= ?2
        """
    )
    Integer countByNgu_van(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.ngoai_ngu <= ?1 and u.ngoai_ngu >= ?2
        """
    )
    Integer countByNgoai_ngu(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.vat_li <= ?1 and u.vat_li >= ?2
        """
    )
    Integer countByVat_li(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.hoa_hoc <= ?1 and u.hoa_hoc >= ?2
        """
    )
    Integer countByHoa_hoc(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.sinh_hoc <= ?1 and u.sinh_hoc >= ?2
        """
    )
    Integer countBySinh_hoc(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.lich_su <= ?1 and u.lich_su >= ?2
        """
    )
    Integer countByLich_su(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.dia_li <= ?1 and u.dia_li >= ?2
        """
    )
    Integer countByDia_li(Double upper, Double lower);

    @Query(
            value = """
            select count(u) from users u
            where u.gdcd <= ?1 and u.gdcd >= ?2
        """
    )
    Integer countByGdcd(Double upper, Double lower);

    @Query(
            value = """
            select u from users u
            where u.toan is not null and u.vat_li is not null and u.hoa_hoc is not null
            order by u.toan desc, u.vat_li desc, u.hoa_hoc desc
        """
    )
    List<User> getTopByToanAndVat_liAndHoa_hoc();
}
