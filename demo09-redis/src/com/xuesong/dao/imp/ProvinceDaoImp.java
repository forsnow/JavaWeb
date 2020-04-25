package com.xuesong.dao.imp;

import com.xuesong.dao.ProvinceDao;
import com.xuesong.domain.Province;
import com.xuesong.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author : Snow
 * @date : 2020/4/23
 */
public class ProvinceDaoImp implements ProvinceDao {
    //声明成员变量 jdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from t_province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }


}
