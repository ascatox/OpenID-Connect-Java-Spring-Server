package it.protectid.filter;

import it.protectid.model.policy.PolicyModel;
import it.protectid.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mitre.openid.connect.request.ConnectRequestParameters.PPM;

@Component("protectIdFilter")
public class ProtectIdFilter extends GenericFilterBean {

	public static final String PROTECTID_AUTHORIZE = "protectid-authorize"; //FIXME Move from here
	public static final String PPM = "ppm"; //FIXME Move from here
	private static final Logger logger = LoggerFactory.getLogger(ProtectIdFilter.class);

	@Autowired
	PolicyService policyService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		PolicyModel policyModel = null;
		try {
			Map<String, String> inputParams = createRequestMap(req.getParameterMap());
			policyModel = policyService.retrievePpm(inputParams.get(PPM));
			session.setAttribute(PPM, policyModel);
			if (PROTECTID_AUTHORIZE.equals(inputParams.get(PROTECTID_AUTHORIZE))) {
				//Authorized Policy
				//TODO
				policyService.acceptPpa("", "");
				//res.sendRedirect("");
			}
			chain.doFilter(request, response);
		} catch (Exception e) {
			logger.error(e.getMessage());
			chain.doFilter(request, response);
		}
	}


	private Map<String, String> createRequestMap(Map<String, String[]> parameterMap) {
		Map<String, String> requestMap = new HashMap<>();
		for (String key : parameterMap.keySet()) {
			String[] val = parameterMap.get(key);
			if (val != null && val.length > 0) {
				requestMap.put(key, val[0]); // add the first value only (which is what Spring seems to do)
			}
		}

		return requestMap;
	}
}
