<%-- 
    Document   : edit
    Created on : Mar 9, 2025, 10:54:29 AM
    Author     : Nguyen Duc Anh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit</title>
        <link rel="stylesheet" href="css/edit.css"/>
    </head>
    <body>
        <div class="container">
            <h2 class="title">🛍️Edit Product</h2>
            <form action="edit" method="post">
                <div class="input-group">
                    <label for="product_name">Product ID</label>
                    <input type="text" name="id" value="${detail.id}" readonly required>
                </div>
                <div class="input-group">
                    <label for="product_name">Product Name</label>
                    <input type="text" name="name" value="${detail.name}" required>
                </div>
                <div class="input-group">
                    <label for="title">Title</label>
                    <textarea type="text" name="title" required>${detail.title}</textarea>
                </div>
                <div class="input-group">
                    <label for="price">Price</label>
                    <input type="number" id="price" name="price" value="${detail.price}" required>
                </div>
                <div class="input-group">
                    <label for="img">Image</label>
                    <input type="text" name="img" value="${detail.image}" required>
                </div>
                <div class="input-group">
                    <label for="description">Description</label>
                    <textarea name="description" rows="2" required>${detail.description}</textarea>
                </div>
                <div class="input-group">
                    <label for="category">Category</label>
                    <select name="category" class="custom-select">
                        <c:forEach items="${listC}" var="o">
                            <option value="${o.id}" ${o.id == detail.cateID ? 'selected' : ''}>${o.cname}</option>
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



