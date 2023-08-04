package com.rusio.pavlovsky.spring.boot312.service;

import com.rusio.pavlovsky.spring.boot312.model.User;
import java.util.List;

public interface UserService {
    public void save(User user);
    public void delete(Long id);
    public User get(Long id);
    public void update(User user);
    public List<User> getAll();
}
