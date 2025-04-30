package com.gos.gos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class DatabaseInitializer {
    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;

    @Autowired
    public DatabaseInitializer(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void importData() {
        try(InputStream is = DatabaseInitializer.class.getResourceAsStream("/diem_thi_thpt_2024.csv")) {
            if (is == null) {
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String[] header = reader.readLine().split(","); // ignore first line

            // test
            User temp = new User();
            temp.setSbd("123");
            userRepository.save(temp);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", header.length);

                User user = new User();
                user.setSbd(data[0]);
                user.setToan(data[1]);
                user.setNgu_van(data[2]);
                user.setNgoai_ngu(data[3]);
                user.setVat_li(data[4]);
                user.setHoa_hoc(data[5]);
                user.setSinh_hoc(data[6]);
                user.setLich_su(data[7]);
                user.setDia_li(data[8]);
                user.setGdcd(data[9]);
                user.setMa_ngoai_ngu(data[10]);

                em.persist(user);
            }
            em.flush();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}