package com.dxs.api.service.impl;

import com.dxs.api.service.JtaService;
import com.dxs.api.util.DateUtil;
import com.dxs.api.util.EncryptUtils;
import com.dxs.api.util.Result;
import com.dxs.api.util.ResultBuilder;
import com.dxs.dao.one.entity.User;
import com.dxs.dao.one.repository.UserMapper;
import com.dxs.dao.two.entity.Admin;
import com.dxs.dao.two.repository.AdminMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JtaServiceImpl
        implements JtaService
{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    public Result read()
    {
        User user = this.userMapper.selectByPrimaryKey(Integer.valueOf(1));
        Admin admin = this.adminMapper.selectByPrimaryKey(Integer.valueOf(1));

        Map map = new HashMap();
        map.put("user", user);
        map.put("admin", admin);

        return new ResultBuilder().setData(map).build();
    }

    @Transactional
    public Result update()
    {
        User user = new User();
        user.setAccount("DevilMafia");
        user.setNickname("大憨豆先生。");
        user.setPassword("123");
        user.setDeleteFlag(Integer.valueOf(0));
        user.setCreateTime(DateUtil.getCurrentDate());

        String salt = EncryptUtils.createSalt();
        String pw = EncryptUtils.encrypt(user.getPassword(), salt);
        user.setPassword(pw);
        user.setSalt(salt);

        Admin admin = new Admin();
        admin.setAccount("DevilMafia");
        admin.setPassword("123");
        admin.setStatus(Integer.valueOf(0));

        this.userMapper.insertSelective(user);

        int n = 10 / 0;

        this.adminMapper.insertSelective(admin);

        return new ResultBuilder().success();
    }
}