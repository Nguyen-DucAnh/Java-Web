<%-- 
    Document   : editorder
    Created on : Mar 24, 2025, 7:35:51 AM
    Author     : Nguyen Duc Anh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit</title>
        <link rel="stylesheet" href="css/edit.css"/>
    </head>
    <body>
        <div class="container">
            <h2 class="title">🛍️Edit Order</h2>
            <form action="editOrder" method="post">
                <div class="input-group">
                    <label for="orderId">Order ID</label>
                    <input type="text" name="id" value="${managerorder.id}" readonly required>
                </div>
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" value="${managerorder.fullname}" readonly required>
                </div>
                <div class="input-group">
                    <label for="statusId">StatusID</label>
                    <textarea type="text" name="statusId" required>${managerorder.statusID.id}</textarea>
                </div>
                <div class="input-group">
                    <label for="totalmoney">Total Money</label>
                    <input type="text" name="totalmoney" value="${managerorder.totalmoney}" readonly required>
                </div>
                <div class="input-group">
                    <label for="statusName">Status Name</label>
                    <select name="statusName" class="custom-select">
                        <c:forEach items="${list}" var="o">
                            <option value="${o.id}" ${o.id == managerorder.statusID.id ? 'selected' : ''}>${o.sName}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" value="edit">💾 Update</button>
            </form>
        </div>
        <script>
            document.getElementById('img').addEventListener('input', function () {
                document.getElementById('preview-img').src = this.value;
            });
        </script>
    </body>
</html>
