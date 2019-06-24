
<%@page import="it.protectid.model.policy.PolicyModel"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- model.jsp -->
<html>
<body>

<% out.println("Policy model:"); %>
<% PolicyModel policy = new PolicyModel();
<% List attributes = (List)policy.getAttributes("attrs");%>

<c:forEach items="${attrs}" var="attribute">
    <tr>
        <td>"${attribute.name}" <c:out value="${attribute.value}"/></td>
    </tr>
</c:forEach>

</body>
</html>
