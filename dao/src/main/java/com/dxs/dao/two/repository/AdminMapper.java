package com.dxs.dao.two.repository;

import com.dxs.dao.two.entity.Admin;

public interface AdminMapper {
    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
     */
    int insert(Admin record);

    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
     */
    int insertSelective(Admin record);

    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
     */
    Admin selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
     */
    int updateByPrimaryKey(Admin record);
}