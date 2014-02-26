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
                <form action="controller?action=regprocess" method="post">
                    <tr>
                        <td>Nama</td>
                        <td>:</td>
                        <td><input type="text" name="nama"/></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>:</td>
                        <td><input type="text" name="username"/></td>
                    </tr><tr>
                        <td>Password</td>
                        <td>:</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>Jabatan</td>
                        <td>:</td>
                        <td><select name="jabatan" style="width: 100%">
                                <c:forEach items="${listJabatan}" var="jabatan">
                                    <option value="${jabatan.idJabatan}">${jabatan.nama}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center"><input type="submit" value="Daftar" /></td>
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