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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * @author : Jake
 * @date : 2022-03-16
 */
@Slf4j
public class CouponNoGenerator implements IdentifierGenerator {

    private final String prefixCouponNo = "CN";

    @Override
    public synchronized Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Connection connection = session.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT MAX(COUPON_NO) AS COUPON_NO FROM COUPON");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String lastCouponNo = rs.getString("COUPON_NO");
                if (lastCouponNo == null) {
                    lastCouponNo = String.format("%010d", 1);
                }
                else {
                    lastCouponNo = lastCouponNo.substring(lastCouponNo.length() - 9, lastCouponNo.length());
                    int currentCouponNo = Integer.parseInt(lastCouponNo) + 1;
                    lastCouponNo = String.format("%010d", currentCouponNo);
                }

                return prefixCouponNo + getCurrentDateFormat() + lastCouponNo;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private String getCurrentDateFormat() {
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(currentDate);
    }

    private static long getCurrentTimeMillis() {
        return Calendar.getInstance(Locale.KOREA).getTimeInMillis();
    }
}
