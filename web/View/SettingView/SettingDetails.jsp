<%-- 
    Document   : SettingDetails
    Created on : Nov 26, 2024, 10:30:19 AM
    Author     : zenzen1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>Setting Details</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <a href="SettingController">Back to List</a>
                    <h1>Setting Details</h1>
                    <form action="SettingController" method="post">
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="name" class="form-label">Name*</label>
                                <input name="name"  class="form-control" id="name" placeholder="Setting Name">
                                <span class="text-danger">abc</span>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="typeId" class="form-label">Type</label>
                                <select name="typeId" class="form-select">
                                    <c:forEach var="setting" items="${requestScope.systemSettingList}" >
                                        <option value="${setting.settingId}">
                                            ${setting.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="value" class="form-label">Value</label>
                            <input  class="form-control" id="value" placeholder="Value">
                        </div>
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="priority" class="form-label">Priority</label>
                                <input type="number" class="form-control" id="priority" placeholder="priority">
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="status" class="form-label">Status</label>
                                <div style="display: flex; gap: 15%;" class="mt-2">
                                    <div class="form-check ">
                                        <input class="form-check-input" type="radio" name="status" id="inlineRadio1" value="true">
                                        <label class="form-check-label" for="inlineRadio1">Active</label>
                                    </div>
                                    <div class="form-check ">
                                        <input class="form-check-input" type="radio" name="status" id="inlineRadio2" value="false">
                                        <label class="form-check-label" for="inlineRadio2">Inactive</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea class="form-control" id="description" rows="3"></textarea>
                        </div>
                        <div class="mb-3">
                            <input type="hidden" name="action" value="${requestScope.action}" />
                            <input class="btn btn-primary" type="submit" value="Submit">
                        </div>
                    </form>
                </div>
                <div class="col-md-4">

                </div>
            </div>
        </div>
    </body>
</html>
