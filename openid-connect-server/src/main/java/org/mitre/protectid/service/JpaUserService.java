package org.mitre.protectid.service;

import org.mitre.openid.connect.model.UserInfo;
import org.mitre.protectid.repository.JpaAuthoritiesRepository;
import org.mitre.openid.connect.repository.impl.JpaUserInfoRepository;
import org.mitre.protectid.repository.JpaUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ascatox
 */
@Service
@Transactional
public class JpaUserService {

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
}
