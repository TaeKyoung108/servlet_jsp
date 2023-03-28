<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: kimta
  Date: 2023-03-22
  Time: 오후 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
<%--    이런 코드는 매우 복작함--%>
<%--    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--    <li>id=<%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--    <li>id=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>

<%--    그래서 위의 코드를 아래로 변경--%>
    <li>id=${member.id}</li>
    <li>id=${member.username}</li>
    <li>id=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
