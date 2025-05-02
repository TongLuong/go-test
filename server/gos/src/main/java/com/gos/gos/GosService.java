package com.gos.gos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class GosService {
    private final UserRepository userRepository;

    @Autowired
    public GosService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
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

    public List<StatisticDto> getAllScores() {
        String[] subjects = new String[] {
                "Toan", "Ngu_van", "Ngoai_ngu", "Vat_li", "Hoa_hoc",
                "Sinh_hoc", "Lich_su", "Dia_li", "Gdcd"
        };

        List<StatisticDto> statistics = new LinkedList<>();
        for (String subject : subjects) {
            try {
                Method method = userRepository.getClass().getMethod(
                        "countBy" + subject,
                        Double.class, Double.class
                );
                StatisticDto statisticDto = new StatisticDto();

                statisticDto.subject = subject;
                statisticDto.excellent = (Integer) method.invoke(userRepository, 10.0, 8.0);
                statisticDto.good = (Integer) method.invoke(userRepository, 7.99, 6.0);
                statisticDto.average = (Integer) method.invoke(userRepository, 5.99, 4.0);
                statisticDto.belowAverage = (Integer) method.invoke(userRepository, 3.99, 0.0);

                statistics.add(statisticDto);
            }
            catch (Exception e) {
                return null;
            }
        }

        return statistics;
    }

    public List<ScoreDto> listTop(Integer top) {
        List<ScoreDto> scores = new LinkedList<>();
        List<User> topUsers = userRepository.getTopByToanAndVat_liAndHoa_hoc();

        for (User user : topUsers) {
            if (top-- <= 0) {
                return scores;
            }

            ScoreDto score = new ScoreDto(user);
            scores.add(score);
        }

        return scores;
    }
}
