<%@page import="it.protectid.model.policy.PolicyModel" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mitre.openid.connect.request.ConnectRequestParameters" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
    PolicyModel policyModel = (PolicyModel) session.getAttribute(ConnectRequestParameters.PPM);
    List<PolicyModel.Attribute> attributes = policyModel.getAttributes();
    Set<String> attributeKeys = policyModel.getAttributeKeys();
%>


<fieldset class="well">
    <legend>
        Policy Model:
    </legend>
    <table class="table">
        <%
            for (String attribute : attributeKeys) {
        %>
        <tr>
             <td><i class="icon-apple"></i></i><%=attribute%></td>
        </tr>
        <% } %>
    </table>
</fieldset>
