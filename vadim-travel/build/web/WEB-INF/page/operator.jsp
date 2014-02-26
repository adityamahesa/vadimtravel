<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>vadimTRAVEL :: As Happy As Your Trip</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="wrapper" style="width: 100%">

        <div id="main" style="background-color: #f2aa2e; width: 100%">
    <h1><a href="index.jsp"><img src="images/logo.gif" width="554" height="47" alt="Vadim Travel" /></a></h1>
    </div><!-- end main -->
	<div class="inner">
            <h2><a href="controller?action=office">Office</a> | <a href="controller?action=operator">Operator</a> | <a href="controller?action=logout">Logout</a></h2>
            ${msg}<br/>
	<!-- <div class="inner" style="margin-left:100px; margin-right:50px; font-size:12px"> -->
        <a href="controller?action=registrasi">Buat Operator Baru</a>
        <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Username</th>
                    <th>Kode Jabatan</th>
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach items="${operator}" var="operator">
                    <tr>
                        <td>${operator.idOperator}</td>
                        <td>${operator.nama}</td>
                        <td>${operator.username}</td>
                        <td>${operator.jabatan.idJabatan}</td>
                        <th><a href="controller?action=editoperator&id=${operator.idOperator}">Edit</a></th>
                        <th><a href="controller?action=deleteoperator&id=${operator.idOperator}">Delete</a></th>
                    </tr>
                </c:forEach>
            </table>


            <div class="clear"></div>
    </div>
      <div id="footer">
          <center>&copy; 2011 CV. VadimTravel</center> </div>
      <!-- end footer -->
  </div><!-- end wrapper -->
</body>
</html>