package com.gig.springboot_concurrency_project.domain.generator;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Jake
 * @date : 2022-03-16
 */
@Slf4j
public class CouponNoGenerator implements IdentifierGenerator {


    @Override
    public synchronized Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Connection connection = session.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("select concat(DATE_FORMAT(now(),'%Y%m%d'), lpad((ifnull(max(order_id),DATE_FORMAT(now(),'%Y%m%d000000')) - DATE_FORMAT(now(),'%Y%m%d000000')  + 1), 6,0)) as order_no from t_order where DATE_FORMAT(order_date,'%Y-%m-%d')=DATE_FORMAT(now(),'%Y-%m-%d')");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Long.parseLong(rs.getString("coupon_no"));
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        }
        return null;
    }
}
