package de.openaqua.batchdemo.dataloaderbatchprocessing.service;

import de.openaqua.batchdemo.dataloaderbatchprocessing.entity.User;
import de.openaqua.batchdemo.dataloaderbatchprocessing.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<List<User>> getUsersByIds(List<String> ids) {
        return CompletableFuture.supplyAsync(() -> userRepository.findAllById(ids));
    }
}
