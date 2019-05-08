package com.zongheanli.dao;

import com.zongheanli.domain.ContactInfo;

import java.util.List;

/**
 * @ClassName:ContactDao
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/5/8 18:47
 * @Version 1.0
 */
public interface ContactDao {
    //查询所有数据
    public List<ContactInfo> queryAll();

    //分页查询数据
    public List<ContactInfo> queryAll(int offset,int size);

    // 删除指定用户
    public int delById(String id);

    // 根据id查询用户信息
    public ContactInfo queryById(String id);

    // 添加通讯录信息
    public int insertContactInfo(ContactInfo contactInfo);

    // 更新通讯录信息
    public int updateContactInfo(ContactInfo contactInfo);

    // 查询通讯录总条数
    public int queryContactInfoSize();


}
