<%@page import="java.util.List"%>

	<%@ include file="/WEB-INF/views/templates/base-header.jsp"%>
	<%@ include file="/WEB-INF/views/templates/header.jsp"%>
	
<h1>Modifier</h1>
<p>
	<%= request.getAttribute("collaborateur").toString() %>
</p>

	<%-- <%@ include file="/WEB-INF/views/templates/scripts.jsp"%> --%>
	<%@ include file="/WEB-INF/views/templates/base-footer.jsp"%>