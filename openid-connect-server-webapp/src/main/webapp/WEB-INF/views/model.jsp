<%@page import="it.protectid.model.policy.PolicyModel" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mitre.openid.connect.request.ConnectRequestParameters" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>

<% out.println("Policy model:"); %>
<%
    PolicyModel policyModel = (PolicyModel) session.getAttribute(ConnectRequestParameters.PPM);
    List<PolicyModel.Attribute> attributes = policyModel.getAttributes();
%>
<table>
    <%
        for (PolicyModel.Attribute attribute : attributes) {
    %>
    <tr>
        <td><%=attribute.getValue()%>
        </td>
        <td><%=attribute.getValue()%>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
