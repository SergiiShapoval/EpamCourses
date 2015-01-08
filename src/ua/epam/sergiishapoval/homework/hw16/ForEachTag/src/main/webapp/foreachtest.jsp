<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 18.12.2014
  Time: 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="myfroeach" uri="ua.sergiishapoval.jstl.foreach" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title></title>
</head>
<body>

<jsp:useBean id="input" class="ua.sergiishapoval.model.Countries" scope="request">
  <jsp:setProperty name="input" property="*"/>
</jsp:useBean>






<c:forEach items="${input.countries}" var="value"  varStatus="status">
  <br/> <с:out value="${value}"/>
  <%--<br/> <c:out value="${status.count}"/>--%>
</c:forEach>


<br/>
<br/>
taglib:
<myfroeach:each id="${input.countries}" var="country" >
 <br/><font size="20"> <c:out value="${country}"/> </font>
</myfroeach:each>

<br/>
<br/>
check country in the end
${country}
<br/>
<br/>
<myfroeach:each id="${input.collection}" var="collectionElement"  >
  <br/> <b><c:out value="${collectionElement}"/></b>
</myfroeach:each>
<br/>
<%--
Info from param:
<br/>
<myfroeach:each id="${param.countries}" var="pais"  >
  <br/> <b><c:out value="${pais}"/></b>
</myfroeach:each>
--%>


</body>
</html>
