package it.protectid.web;

import it.protectid.service.UserService;
import org.mitre.openid.connect.model.DefaultUserInfo;
import org.mitre.openid.connect.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * @author ascatox
 */

@Controller
public class UserInfoController {
	@Autowired
	UserService userService;
	private final String PASSWORD = "password"; //TODO

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserInfo userDto = new DefaultUserInfo();
		model.addAttribute("user", userDto);
		return "login?register=true";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String postUserInfoData(WebRequest request) throws Exception {
		BuildUserInfo buildUserInfo = new BuildUserInfo(request).invoke();
		UserInfo user = getUserInfo(buildUserInfo);
		user.setPreferredUsername(user.getEmail());
		try {
			final UserInfo userInfo = userService.createUser(user, PASSWORD);
			return "Users with email " + userInfo.getEmail() + " and SUB " + userInfo.getSub() + " created correctly";
		} catch (Exception e) {
			return "Error encountered: " + e.getMessage();
		}
	}

	private UserInfo getUserInfo(BuildUserInfo buildUserInfo) {
		UserInfo user = buildUserInfo.getUser();
		String email = buildUserInfo.getEmail();
		String name = buildUserInfo.getName();
		String lastName = buildUserInfo.getLastName();
		String gender = buildUserInfo.getGender();
		String dob = buildUserInfo.getDob();
		user.setEmail(email);
		user.setName(name);
		user.setFamilyName(lastName);
		user.setGender(gender);
		user.setBirthdate(dob);
		return user;
	}

	private class BuildUserInfo {
		private WebRequest request;
		private UserInfo user;
		private String email;
		private String name;
		private String lastName;
		private String gender;
		private String dob;

		public BuildUserInfo(WebRequest request) {
			this.request = request;
		}

		public UserInfo getUser() {
			return user;
		}

		public String getEmail() {
			return email;
		}

		public String getName() {
			return name;
		}

		public String getLastName() {
			return lastName;
		}

		public String getGender() {
			return gender;
		}

		public String getDob() {
			return dob;
		}

		public BuildUserInfo invoke() {
			user = new DefaultUserInfo();
			email = request.getParameter("email");
			name = request.getParameter("name");
			lastName = request.getParameter("last-name");
			gender = request.getParameter("gender");
			String cf = request.getParameter("cf");
			dob = request.getParameter("dob");
			String cap = request.getParameter("cap");
			String street = request.getParameter("street");
			String state = request.getParameter("state");
			return this;
		}
	}
}

