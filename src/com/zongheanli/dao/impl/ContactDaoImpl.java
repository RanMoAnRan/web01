package com.zongheanli.dao.impl;

import com.zongheanli.dao.ContactDao;
import com.zongheanli.domain.ContactInfo;
import com.zongheanli.utils.DBUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName:ContactDaoImpl
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/5/8 18:47
 * @Version 1.0
 */
public class ContactDaoImpl implements ContactDao {
    JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate();

    @Override
    public List<ContactInfo> queryAll() {
        String sql = "select * from contact_info WHERE del=0";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class));
    }

    @Override
    public List<ContactInfo> queryAll(int offset, int size) {
        String sql = "select * from contact_info WHERE del=0 limit ?,?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class), offset, size);
    }

    @Override
    public int delById(String id) {
        String sql = "update contact_info set del=1 where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public ContactInfo queryById(String id) {
        String sql = "select * from contact_info WHERE id=? and del=0";
        List<ContactInfo> contactInfoQueryById = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class), id);
        if (contactInfoQueryById.isEmpty()) {
            return null;
        } else {
            return contactInfoQueryById.get(0);
        }

    }

    @Override
    public int insertContactInfo(ContactInfo contactInfo) {
        String sql = "insert into contact_info values(null,?,?,?,?,?,?,0)";
        return jdbcTemplate.update(sql, contactInfo.getName(),
                contactInfo.getGender(),
                contactInfo.getBirthday(),
                contactInfo.getBirthplace(),
                contactInfo.getMobile(),
                contactInfo.getEmail());
    }

    @Override
    public int updateContactInfo(ContactInfo contactInfo) {
        String sql = "update contact_info set name=?, gender=?, birthday=?, birthplace=?, mobile=?, email=? WHERE id=? AND del=0";
        return jdbcTemplate.update(sql, contactInfo.getName(),
                contactInfo.getGender(),
                contactInfo.getBirthday(),
                contactInfo.getBirthplace(),
                contactInfo.getMobile(),
                contactInfo.getEmail(),
                contactInfo.getId());
    }

    @Override
    public int queryContactInfoSize() {
        String sql = "select count(*) from contact_info where del=0";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
