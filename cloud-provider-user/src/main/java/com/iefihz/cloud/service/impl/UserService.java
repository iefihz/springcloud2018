package com.iefihz.cloud.service.impl;

import com.iefihz.cloud.entity.User;
import com.iefihz.cloud.repository.UserRepository;
import com.iefihz.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        User user = userRepository.getOne(id);
        Long id_ = user.getId();
        String username_ = user.getUsername();
        short age_ = user.getAge();
        return user;
    }
}
