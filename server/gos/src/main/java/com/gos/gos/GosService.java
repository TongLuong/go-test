package com.gos.gos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class GosService {
    private final UserRepository userRepository;

    @Autowired
    public GosService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;

//        try(InputStream is = DatabaseInitializer.class.getResourceAsStream("/diem_thi_thpt_2024.csv")) {
//            if (is == null) {
//                return;
//            }
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            String[] header = reader.readLine().split(","); // ignore first line
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",", header.length);
//
//                // check existence
//                User checkUser = userRepository.findBySbd(data[0]);
//                if (checkUser != null) {
//                    continue;
//                }
//
//                User user = new User();
//                user.setSbd(data[0]);
//                user.setToan(data[1]);
//                user.setNgu_van(data[2]);
//                user.setNgoai_ngu(data[3]);
//                user.setVat_li(data[4]);
//                user.setHoa_hoc(data[5]);
//                user.setSinh_hoc(data[6]);
//                user.setLich_su(data[7]);
//                user.setDia_li(data[8]);
//                user.setGdcd(data[9]);
//                user.setMa_ngoai_ngu(data[10]);
//
//                this.userRepository.save(user);
//            }
//        }
//        catch(Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public ScoreDto getScore(
            String sbd
    ) {
        User user = userRepository.findBySbd(sbd);
        if (user == null) {
            return null;
        }

        return new ScoreDto(user);
    }
}
