<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="node" items="${node.listChildCompanies}">
        <!-- TODO: print the node here -->
        <c:set var="depth" value="${depth + 1}"/>

        <tr>
            <td>
                <c:forEach begin="0" end="${depth}" step="1" varStatus="loop">
                    <c:out value="-"/>
                </c:forEach>
                ${node.name}</td>
            <td>${node.earnings}</td>
            <td>0</td>
            <td><a href="edit/${node.id}">Edit</a></td>
            <td><a href="delete/${node.id}">Delete</a></td>
        </tr>

        <c:set var="node" value="${node}" scope="request"/>
        <jsp:include page="element.jsp"/>
    </c:forEach>

</body>
</html>
