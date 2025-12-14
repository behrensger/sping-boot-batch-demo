package de.openaqua.batchdemo.dataloaderbatchprocessing;

import de.openaqua.batchdemo.dataloaderbatchprocessing.entity.User;
import de.openaqua.batchdemo.dataloaderbatchprocessing.service.UserService;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;


@Component
public class UserDataLoader {

    private final UserService userService;

    public UserDataLoader(UserService userService) {
        this.userService = userService;
    }

    public DataLoader<String, User> createUserLoader() {
        BatchLoader<String, User> userBatchLoader = ids -> {
            return userService.getUsersByIds(ids)
                    .thenApply(users -> {
                        Map<String, User> userMap = users.stream()
                                .collect(Collectors.toMap(User::getId, user -> user));
                        return ids.stream()
                                .map(userMap::get)
                                .collect(Collectors.toList());
                    });
        };

        return DataLoaderFactory.newDataLoader(userBatchLoader);
    }
}