package com.qburst.bloodbank.servicesImpl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.qburst.bloodbank.dao.BloodSearchDao;
import com.qburst.bloodbank.model.UserVO;
import com.qburst.bloodbank.services.BoodSearchService;

/**
 * @author Akhil Vennakkat(2736)
 *
 */
public class BloodSearchServiceImpl implements BoodSearchService {

	@Autowired
	private BloodSearchDao bloodSearchDao;
	public Response searchForBlood(String bloodGroup, String location) {
		if((bloodGroup==null|| bloodGroup.trim().equals("")) &&(location==null|| location.trim().equals("")) ){
			 return Response.status(Response.Status.BAD_REQUEST).build();
		}
			List<UserVO> users=bloodSearchDao.searchForBlood(bloodGroup,location);
		    return Response.ok(users).build();
	}
}
