package com.qburst.bloodbank.daoImpl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.qburst.bloodbank.dao.UserDao;
import com.qburst.bloodbank.model.UserVO;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public boolean registerUser(UserVO userVO) {

		String insertSql = "INSERT INTO qb_user_details (" + "	USER_NAME, " + "	USER_ID, " + "	PREFFERED_NAME, "
				+ "	MOBILE_NO, " + "	EMAIL_ID, " + "	WEIGHT, " + "	LOCATION, " + "	GENDER, " + "	BLOOD_GROUP, "
				+ " PASSWORD )" + " VALUES (?, ?, ?, ?,?, ?, ?, ?,?,?)";

		Object[] params = new Object[] { userVO.getUserName(), userVO.getUserId(), userVO.getPreferredName(),
				userVO.getMobileNo(), userVO.getEmail(), userVO.getWeight(), userVO.getLocation(), userVO.getGender(),
				userVO.getBloodGroup(), userVO.getPassword() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int row = jdbcTemplate.update(insertSql, params, types);
		System.out.println(row + " row inserted.");
		return true;
	}

	/**
	 * Getter method for the variable dataSource
	 * 
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Setter method for the variable dataSource
	 * 
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
