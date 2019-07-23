//package it.protectid.web;
//
//import it.protectid.service.DIRService;
//import it.eng.protectid.model.client.Dp;
//import it.eng.protectid.model.authority.Sid;
//import it.protectid.pdw.MyPdwManager;
//import it.protectid.repository.JpaPpmRepository;
//import it.protectid.utils.JsonConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.request.WebRequest;
//
///**
// * @author ascatox
// */
//@Controller
//public class PolicyController {
//
//	@Autowired
//	MyPdwManager myPdwManager;
//	DIRService dirService;
//	JpaPpmRepository jpaPpmRepository;
//
//	@RequestMapping(value = "/emit", method = RequestMethod.POST)
//	public void subscribe(WebRequest request, Model model) throws Exception {
//		//TODO Business Logic to implement policy emission
//		final String userId = request.getParameter("user_id");
//		final String clientId = request.getParameter("client_id");
//		final String ppm = request.getParameter("ppm");
//		final Sid sid = myPdwManager.getSidById(userId);
//		model.addAttribute("sid", sid);
//		model.addAttribute("redirect_uri", "");
//		final Dp dataProvider = (Dp) JsonConverter.jsonToObject(dirService.invoke(DIRService.Function.getDP.name(), null), Dp.class);
//		model.addAttribute("dp", dataProvider);
//		jpaPpmRepository.getById(ppm);
//	}
//
//	@RequestMapping(value = "/apply", method = RequestMethod.POST)
//	public void approve(WebRequest request) {
//		//TODO Business Logic to implement policy consensus
//
//	}
//
//
//}
