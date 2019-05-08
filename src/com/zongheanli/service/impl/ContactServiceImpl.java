package com.zongheanli.service.impl;

import com.zongheanli.dao.ContactDao;
import com.zongheanli.dao.impl.ContactDaoImpl;
import com.zongheanli.domain.ContactInfo;
import com.zongheanli.service.ContactService;

import java.util.List;

/**
 * @ClassName:ContactServiceImpl
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/5/8 18:47
 * @Version 1.0
 */
public class ContactServiceImpl implements ContactService {
    ContactDao contactDao = new ContactDaoImpl();

    @Override
    public List<ContactInfo> queryAll() {
        return contactDao.queryAll();
    }

    @Override
    public List<ContactInfo> queryAll(int offset, int size) {
        return contactDao.queryAll(offset,size);
    }

    @Override
    public boolean delById(String id) {
        int resultdao = contactDao.delById(id);
        return resultdao==1;
    }

    @Override
    public ContactInfo queryById(String id) {
        return contactDao.queryById(id);
    }

    @Override
    public boolean insertContactInfo(ContactInfo contactInfo) {
        return contactDao.insertContactInfo(contactInfo)==1;
    }

    @Override
    public boolean updateContactInfo(ContactInfo contactInfo) {
        return contactDao.updateContactInfo(contactInfo)==1;
    }

    @Override
    public int queryContactInfoSize() {
        return contactDao.queryContactInfoSize();
    }
}
