package com.qburst.bloodbank.dao;

import java.util.List;

import com.qburst.bloodbank.model.UserVO;

public interface BloodSearchDao {
	
	/**
	 * @param bloodGroup
	 * @param location
	 * @return
	 */
	public List<UserVO> searchForBlood(String bloodGroup, String location); 
}
