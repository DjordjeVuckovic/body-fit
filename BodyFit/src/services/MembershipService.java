package services;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Adress;
import beans.FacilityType;
import beans.Membership;
import beans.MembershipType;
import beans.RandomGenerator;
import beans.SportFacility;
import dao.MembershipDao;
import dto.FacilityViewDto;
import dto.MembershipViewDto;

@Path("memberships")
public class MembershipService {
	MembershipDao membershipDao = new MembershipDao();
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if(ctx.getAttribute("memberships")== null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("memberships", new MembershipService());
		}
	}
	
	
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Membership> getAllMemberships() {
		membershipDao.setBasePath(getContext());
		return membershipDao.getAllToList();
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<MembershipViewDto> getAllMembershipDto() {
		membershipDao.setBasePath(getContext());
		ArrayList<MembershipViewDto> membershipViewDtos = new ArrayList<MembershipViewDto>();
		for (Membership m : membershipDao.getAllToList()) {
			membershipViewDtos.add(new MembershipViewDto(m));
		}
		return membershipViewDtos;
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMembership(@PathParam("id") String id) {
		membershipDao.setBasePath(getContext());
		membershipDao.delete(id);
		
	}
	
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Membership createMembership(MembershipViewDto membershipViewDto) {
		membershipDao.setBasePath(getContext());
		Membership membership = new Membership(RandomGenerator.usingRandomUUID(),MembershipType.valueOf(membershipViewDto.type),membershipViewDto.paymentDate,
				membershipViewDto.dateAndTimeOfValidity,membershipViewDto.price, membershipViewDto.customerId, true, membershipViewDto.numberOfSession);
		membershipDao.create(membership);
		return membership;
	}
}
