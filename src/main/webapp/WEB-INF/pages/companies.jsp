<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
</head>

<body>
    <a class="btn btn-sm btn-info" onclick="add('Add company')" >Add company</a>

    <table class="table" id="datatable">
        <thead>
            <%--<th>#</th>--%>
            <th>Name</th>
            <th>Company Earnings</th>
            <th>Total Earnings</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <c:forEach var="node" items="${companyList}">
            <tr>
                <td>-${node.name}</td>
                <td>${node.earnings}</td>
                <td>0</td>
                <td><a href="edit/${node.id}">Edit</a></td>
                <td><a href="delete/${node.id}">Delete</a></td>
            </tr>
            <c:set var="node" value="${node}" scope="request"/>
            <c:set var="depth" value="${0}" scope="request"/>
            <jsp:include page="element.jsp"/>
        </c:forEach>

    </table>

    <div class="modal fade" id="editRow">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h2 class="modal-title" id="modalTitle"></h2>
                </div>
                <div class="modal-body">
                    <form:form class="form-horizontal" method="post" id="detailsForm">
                        <input type="text" hidden="hidden" id="id" name="id">

                        <div class="form-group">
                            <label for="name" class="control-label col-xs-3">Name</label>

                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="earnings" class="control-label col-xs-3">Earnings</label>

                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="earnings" name="earnings" placeholder="Earnings">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-offset-3 col-xs-9">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/companyUtil.js"></script>
</body>

</html>
