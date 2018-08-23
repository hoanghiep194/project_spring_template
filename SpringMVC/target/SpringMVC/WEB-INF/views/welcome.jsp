<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="run.spring.mvc.model.Books"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<body>
    Hello
     <a href="${pageContext.request.contextPath}/info">View profile</a>
</br>
Session of User : <c:out value="${username}"></c:out>
</body>
</html>
