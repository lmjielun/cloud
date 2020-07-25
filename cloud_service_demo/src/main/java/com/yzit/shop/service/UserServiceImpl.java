package com.yzit.shop.service;

import com.yzit.shop.dao.UserMapper;
import com.yzit.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public User findById(Long id) {
      /*  try {
            // 为了演示超时现象，我们在这里让线程休眠,时间随机 0~2000毫秒
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return userDao.selectByPrimaryKey(id);
    }
}
