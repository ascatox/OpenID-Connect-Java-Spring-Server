<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<o:header title="Log In" />
<script type="text/javascript">
	<!--
	$(document).ready(function () {
		// select the appropriate field based on context
		$('#<c:out value="${ login_hint != null ? '
			j_password ' : '
			j_username ' }" />').focus();
	});

	//
	-->
</script>
<o:topbar />
<div class="container-fluid main">

	<h1 id="login-message">
		<spring:message code="login.login_with_username_and_password" />
	</h1>
	<h1 id="register-message" style="display:none;">
    		<spring:message text="Register your data" />
    </h1>

	<c:if test="${ param.error != null }">
		<div class="alert alert-error">
			<spring:message code="login.error" />
		</div>
	</c:if>

	<div class="row-fluid" id="login-form">
		<div class="span4 offset1 well">
			<form action="${ config.issuer }${ config.issuer.endsWith('/') ? '' : '/' }login" method="POST">
				<div>
					<div class="input-prepend input-block-level">
						<span class="add-on"><i class="icon-user"></i></span>
						<input type="text" placeholder="<spring:message code=" login.username" />" autocorrect="off"
						autocapitalize="off" autocomplete="off" spellcheck="false" value="<c:out value="${ login_hint }" />" id="j_username" name="username"> />
					</div>
				</div>
				<div>
					<div class="input-prepend input-block-level">
						<span class="add-on"><i class="icon-lock"></i></span>
						<input type="password" placeholder="<spring:message code=" login.password" />" autocorrect="off"
						autocapitalize="off" autocomplete="off" spellcheck="false" id="j_password" name="password" />
					</div>
				</div>
				<div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" class="btn" value="<spring:message code="login.login-button" />" name="submit"/>
					<input type="button" id="register-button" class="btn" value="<spring:message text=" Register" />" />
				</div>
			</form>
		</div>
	</div>


	<div class="row-fluid" id="register-form" style="display:none">
		<div class="span3 offset1 well">
			<form action="${ config.issuer }${ config.issuer.endsWith('/') ? '' : '/' }register" method="POST">
				<div class="form-group">
					<label for="email">Email address</label>
					<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
						placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="name">Name</label>
					<input type="text" class="form-control" id="name" name="name" placeholder="Name">
				</div>
				<div class="form-group">
					<label for="last-name">Last Name</label>
					<input type="text" class="form-control" id="last-name" name="last-name" placeholder="Last Name">
				</div>
				<div class="form-group">
                    <label for="gender">Gender</label>
                	<select id="gender" name="gender">
                        <option value=""></option>
                        <option value="M">M</option>
                        <option value="F">F</option>
                	</select>
               	</div>
				<div class="form-group">
					<label for="cf">CF</label>
					<input type="text" class="form-control" name="cf" id="cf" placeholder="CF "">
				</div>
				<div class=" form-group">
					<label for="dob">Date of Birth</label>
					<input type="date" class="form-control" id="dob" name="dob" placeholder="Date of Birth">
				</div>
				<div class=" form-group">
                    <label for="cap">Postal Code</label>
                	<input type="text" class="form-control" id="cap" name="cap" placeholder="Postal Code">
                </div>
                <div class=" form-group">
                   <label for="street">Street</label>
                   <input type="text" class="form-control" id="street" name="street" placeholder="Street">
                 </div>
                <div class=" form-group">
                    <label for="state">State</label>
                    <input type="text" class="form-control" id="state" name="state" placeholder="State">
                </div>
				<input type="hidden" name="" value="" />
				<input type="button" id="cancel-button" class="btn" value="Cancel" name="cancel"/>
				<input type="submit" id="register-button" class="btn" value="Register" name="submit"/>
			</form>
		</div>
	</div>
</div>
<o:footer />


<script type="text/javascript">
	var isClicked = false;
	$("#register-button").click(function () {
		if (!isClicked) {
			$("#register-form").show();
			$("#login-form").hide();
			$("#login-message").hide();
			$("#register-message").show();
			isClicked = true;
		} else {
			$("#register-form").hide();
			$("#login-form").show();
			$("#login-message").show();
            $("#register-message").hide();
			isClicked = false;
		}
	});
	$("#cancel-button").click(function () {
	    window.location.href = "${ config.issuer }${ config.issuer.endsWith('/') ? '' : '/' }login";

  	});
</script>
