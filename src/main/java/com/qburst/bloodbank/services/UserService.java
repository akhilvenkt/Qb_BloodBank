/**
 * This class file is the property of QBurst technologies.
 * All rights reserved 2016
 */
package com.qburst.bloodbank.services;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.qburst.bloodbank.model.UserVO;

/**
 * @author Akhil Vennakkat(2736)
 * Interface for all user related operations like user creation, delete user etc
 */
@Path("/user")
@WebService(name="userService")
public interface UserService {

	@POST
	@Path("/register")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response  registerUser( UserVO userVO);
}
