package com.dxs.dao.one.repository;

import com.dxs.dao.one.entity.User;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    User selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    int updateByPrimaryKey(User record);
}