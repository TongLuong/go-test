package com.gos.gos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
