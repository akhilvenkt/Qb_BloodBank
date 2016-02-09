package com.qburst.bloodbank.services;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Akhil
 * Interface for search blood
 *
 */
@Path("/bloodSearch")
@WebService(name = "bloodSearchService")
public interface BoodSearchService {
	/**
	 * This is method is for searching Blood group based on location and blood
	 * group
	 * 
	 * @param location
	 * @param bloodGroup
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{location}/{bloodGroup}")
	public Response searchForBlood(@PathParam("location") String location, @PathParam("bloodGroup") String bloodGroup);

}
