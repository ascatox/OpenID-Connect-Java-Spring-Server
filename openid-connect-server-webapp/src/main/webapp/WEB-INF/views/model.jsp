<%@page import="it.protectid.model.policy.PolicyModel" %>
<%@ page import="it.protectid.onto.PolicyModelReader" %>
<%@ page import="org.mitre.openid.connect.request.ConnectRequestParameters" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
    PolicyModel policyModel = (PolicyModel) session.getAttribute(ConnectRequestParameters.PPM);
    PolicyModel policyModelSorted = PolicyModelReader.sortFieldsByFinalityAndMandatory(policyModel);
%>
<br/>
<br/>
<fieldset class="well">
    <legend>
        Policy Model:
    </legend>
    <table class="table">
        <thead class="thead-dark">
        <th>
            Name
        </th>
        <th>
            Finality
        </th>
        </thead>
        <%
            String finality = "";
            String htmlInLine = "";

            for (PolicyModel.Attribute attribute : policyModelSorted.getPersonalData()) {
             htmlInLine = "";
             if(null != finality && !"".equals(finality) && !finality.equals(attribute.getFinality()))
                htmlInLine = "<tr><td><input type=\"checkbox\" name=\"accept\" value=\"Accept\" id=\"consensus\" name=\"consensus\"> <label for=\"consensus\">Do il Consenso</label></td><tr/>";
        %>
         <%=htmlInLine%>
            <tr>
                <td><i class="icon-list-alt"></i></i><%=attribute.getName()%></td>
                <td><%=attribute.getFinality()%></td>
            </tr>
        <%
           finality = attribute.getFinality();
          }
        %>
    </table>
</fieldset>
