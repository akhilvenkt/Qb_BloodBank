/**
 * This class file is the property of QBurst technologies.
 * All rights reserved 2016
 */
package com.qburst.bloodbank.servicesImpl;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.qburst.bloodbank.dao.UserDao;
import com.qburst.bloodbank.model.UserVO;
import com.qburst.bloodbank.services.UserService;

/**
 * @author Akhil Vennakkat(2736)
 *
 */
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public Response registerUser(UserVO userVO ) {
		userDao.registerUser(userVO);
		return new ResponseBuilderImpl().build();
	}

}
