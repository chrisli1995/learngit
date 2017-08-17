<%--
  Created by IntelliJ IDEA.
  User: lwd
  Date: 2017/8/2
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--接受值-->
<jsp:useBean id="u" class="domain.User"></jsp:useBean>
<jsp:setProperty name="u" property="username"/>
<jsp:setProperty name="u" property="password"/>

<!--打印值-->
<jsp:getProperty name="u" property="username"/>
</body>
</html>
