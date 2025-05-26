<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            background: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .modal-content {
            padding: 20px;
        }
    </style>
</head>
<body>

<!-- Modal -->
<div id="editEmployeeModal" class="modal fade in" role="dialog" style="display: block;">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="editaccount" method="post">
                <div class="modal-header">						
                    <h4 class="modal-title">Edit account</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">					
                    <div class="form-group">
                        <label>Id</label>
                        <input type="text" name="eid" value ="${acc.id}" class="form-control" readonly required>
                        
                        <label>Old Password</label>
                        <input type="text" name="oldpass" value ="" class="form-control" placeholder="Please enter here." required>
                        <h5 style="color: red">${requestScope.ms3}</h5>
                        
                        <label>New Password</label>
                        <input type="password" name="pass" value ="" class="form-control" placeholder="Please enter here." required>                        

                    </div>
                    <div class="form-group">
                        <label>New Password again</label>
                        <input type="password" name="pass2" value="" class="form-control" placeholder="Please enter here." required>
                         <h5 style="color: red">${requestScope.ms2}</h5>
                    </div>
                </div>
                <div class="modal-footer">
                      <a href="profile.jsp"><button type="button" class="btn btn-default">Out</button>
                      <button type="submit" class="btn btn-primary">Change</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>