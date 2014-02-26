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
            <a href="controller?action=operator">&lt;&lt;Kembali ke Halaman Operator</a>
            <table>
                <form action="controller?action=confirmeditoperator" method="post">
                    <tr>
                        <td>ID</td>
                        <td>:</td>
                        <td><input type="hidden" name="id" value="${operator.idOperator}" />${operator.idOperator}</td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>:</td>
                        <td><input type="text" name="nama" value="${operator.nama}" /></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>:</td>
                        <td><input type="text" name="username" value="${operator.username}" /></td>
                    </tr>
                    <tr>
                        <td>Jabatan</td>
                        <td>:</td>
                        <td><select name="jabatan">
                                <c:forEach items="${jabatan}" var="jabatan">
                                    <c:choose>
                                        <c:when test="${jabatan.idJabatan == operator.jabatan.idJabatan}">
                                            <option value="${jabatan.idJabatan}" selected>${jabatan.nama}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${jabatan.idJabatan}">${jabatan.nama}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center"><input type="submit" value="Edit!" /></td>
                    </tr>
                </form>
                </table>
            <div class="clear"></div>
    </div>
      <div id="footer">
          <center>&copy; 2011 CV. VadimTravel</center> </div>
      <!-- end footer -->
  </div><!-- end wrapper -->
</body>
</html>