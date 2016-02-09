/**
 * This class file is the property of QBurst technologies.
 * All rights reserved 2016
 */
package com.qburst.bloodbank.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.qburst.bloodbank.model.UserVO;

/**
 * @author Akhil Vennakkat(2736)
 *
 */
public class UserMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO userVO= new UserVO();
		userVO.setBloodGroup(rs.getString("BLOOD_GROUP"));
		userVO.setEmail(rs.getString("EMAIL_ID"));
		userVO.setGender(rs.getString("GENDER"));
		userVO.setLocation(rs.getString("LOCATION"));
		userVO.setMobileNo(rs.getString("MOBILE_NO"));
		userVO.setPreferredName(rs.getString("PREFFERED_NAME"));
		return userVO;
	}

}
