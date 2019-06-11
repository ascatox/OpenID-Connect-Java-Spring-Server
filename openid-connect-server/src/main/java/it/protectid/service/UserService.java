package it.protectid.service;

import org.mitre.openid.connect.model.UserInfo;
import it.protectid.model.authority.Authorities;
import it.protectid.model.user.Users;
import it.protectid.repository.JpaAuthoritiesRepository;
import org.mitre.openid.connect.repository.impl.JpaUserInfoRepository;
import it.protectid.repository.JpaUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ascatox
 */
@Service
@Transactional
public class UserService {

	@Autowired
	JpaUserInfoRepository jpaUserInfoRepository;
	@Autowired
	JpaUsersRepository jpaUsersRepository;
	@Autowired
	JpaAuthoritiesRepository jpaAuthoritiesRepository;

	@Transactional
	public UserInfo createUser(UserInfo userInfo, String password) throws Exception {
		final UserInfo byUsername = jpaUserInfoRepository.getByUsername(userInfo.getPreferredUsername());
		final UserInfo user = jpaUserInfoRepository.createUser(userInfo);
		if (null == byUsername) {
			jpaUsersRepository.createUser(user.getPreferredUsername(), password);
			jpaAuthoritiesRepository.createAuthority(user.getPreferredUsername());
		}
		return user;
	}

	@Transactional
	public void removeUser(UserInfo userInfo) throws Exception {
		final UserInfo byUsername = jpaUserInfoRepository.getByUsername(userInfo.getPreferredUsername());
		final List<Authorities> authorities = jpaAuthoritiesRepository.getAuthorityByUsername(byUsername.getPreferredUsername());
		final List<Users> users = jpaUsersRepository.getUserByUsername(byUsername.getPreferredUsername());
		if (null == byUsername && null != authorities && null != users && !authorities.isEmpty() && !users.isEmpty()) {
			jpaUsersRepository.delete(users.get(0));
			jpaAuthoritiesRepository.delete(authorities.get(0));
			jpaUserInfoRepository.removeUser(byUsername);
		}
	}

	@Transactional
	public UserInfo getUserByPid(String pid) {
		return jpaUserInfoRepository.getByPid(pid);
	}


}
