package com.zongheanli.service;

import com.zongheanli.domain.ContactInfo;

import java.util.List;

/**
 * @ClassName:ContactService
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/5/8 18:46
 * @Version 1.0
 */
public interface ContactService {
    //查询所有数据
    public List<ContactInfo> queryAll();

    //分页查询数据
    public List<ContactInfo> queryAll(int offset,int size);

    // 删除指定用户
    public boolean delById(String id);

    // 查询通指定用户
    public ContactInfo queryById(String id);

    // 添加通讯录信息
    public boolean insertContactInfo(ContactInfo contactInfo);

    // 更新通讯录信息
    public boolean updateContactInfo(ContactInfo contactInfo);

    // 查询通讯录总条数
    public int queryContactInfoSize();
}
