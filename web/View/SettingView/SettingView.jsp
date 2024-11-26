<%-- 
    Document   : SettingView
    Created on : Nov 25, 2024, 7:45:37 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <h1>Setting List</h1>
                    <div style="margin: 0 0 20px 0">
                        <div class="row">
                            <div class="col-md-7">
                                <div style="display: flex">
                                    <select>
                                        <option>All</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <a href="SettingController?action=${requestScope.addSettingAction}">New Setting</a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-bordered border-primary">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Value</th>
                            <th>Priority</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="setting" items="${requestScope.settingList}" >
                            <tr>
                                <td>${setting.settingId}</td>
                                <td>${setting.name}</td>
                                <td>${setting.type == null ? "Null" : "Not null"}</td>
                                <td>${setting.value}</td>
                                <td>${setting.priority == null ? "Null" : "Not null"}</td>
                                <td>${setting.status ? "Active" : "Inactive"}</td>
                                <td>
                                    <c:set var="settingId" value="${setting.settingId}"/>
                                    <c:if test='<%=!((List<Integer>)request.getAttribute("systemSettingIds")).stream().anyMatch(id -> id == (int)pageContext.getAttribute("settingId"))%>'>
                                        <a href="SettingController?action=${requestScope.editSettingAction}&settingId=${setting.settingId}">Edit</a>
                                        <c:set var="status" value="${setting.status}" />
                                        <c:choose>
                                            <c:when test = "${status}">
                                                Deactivate
                                            </c:when>

                                            <c:when test = "${!status}">
                                                Activate
                                            </c:when>

                                            <c:otherwise>

                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </td> 
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-3">

                </div>
            </div>
        </div>

    </body>
</html>
