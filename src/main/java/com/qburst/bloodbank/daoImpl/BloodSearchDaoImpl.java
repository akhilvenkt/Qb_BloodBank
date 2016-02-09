package com.qburst.bloodbank.daoImpl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.qburst.bloodbank.dao.BloodSearchDao;
import com.qburst.bloodbank.dao.mapper.UserMapper;
import com.qburst.bloodbank.model.UserVO;

public class BloodSearchDaoImpl implements BloodSearchDao{

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public List<UserVO> searchForBlood(String bloodGroup, String location) {
		StringBuilder queryBuilder=new StringBuilder("SELECT PREFFERED_NAME, BLOOD_GROUP,GENDER, LOCATION, MOBILE_NO, EMAIL_ID FROM qb_user_details");
		Object[] args = null;
		//dynamic query construction and argument setting happens here
		if((location!=null && !"".equals(location) )&& (bloodGroup!=null && !"".equals(bloodGroup) )){
			
			queryBuilder.append(" WHERE UPPER(LOCATION) = ? ");
			queryBuilder.append("AND UPPER(BLOOD_GROUP) = ? ");
			args=new Object[2];
			args[0]=location;
			args[1]=bloodGroup;
		}else if(bloodGroup!=null && !"".equals(bloodGroup) ){
			
			queryBuilder.append(" WHERE UPPER(BLOOD_GROUP) = ? ");
			args=new Object[1];
			args[0]=bloodGroup;
		}else if(location!=null && !"".equals(location) ){
			
			queryBuilder.append(" WHERE UPPER(LOCATION) = ? ");
			args=new Object[1];
			args[0]=location;
		}
		String query=queryBuilder.toString().toString();
		List<UserVO> users=jdbcTemplate.query(query, args,new UserMapper());
		return users;
	}
	

	/**
	 * Getter method for the variable dataSource
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Setter method for the variable dataSource 
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
