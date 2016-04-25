<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <p>Awesome.. Following file  is uploaded successfully.</p>
         <table width="80%" border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th width="4%">No</th>
            <th width="30%">Filename</th>
            
            <th width="20%">&nbsp;</th>
        </tr>
        <c:choose>
            <c:when test="${files != null}">
                <c:forEach var="file" items="${files}" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${file}</td>
                        
                       <td><div align="center"><a href="download.htm?id=${ids}">Download</a> </div></td>
                        
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
 
</body>
</html>