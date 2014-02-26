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
            <a href="controller?action=office">&lt;&lt;Kembali ke Halaman Office</a>
            <center><table>
                <form action="controller?action=confirmedit" method="post">
                    <tr>
                        <td>ID</td>
                        <td>:</td>
                        <td><input type="hidden" name="id" value="${order.travelOrder.idTravelOrder}" />${order.travelOrder.idTravelOrder}</td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>:</td>
                        <td>${order.travelOrder.nama}</td>
                    </tr>
                    <tr>
                        <td>Tanggal Berangkat</td>
                        <td>:</td>
                        <td><input type="text" name="tgl_berangkat" value="${order.travelOrder.tglBerangkat}" /></td>
                    </tr>
                    <tr>
                        <td>Jam Berangkat</td>
                        <td>:</td>
                        <td><input type="text" name="jam_berangkat" value="${order.travelOrder.jamBerangkat}" /></td>
                    </tr>
                    <tr>
                        <td>Tujuan</td>
                        <td>:</td>
                        <td><select name="tujuan">
                                <c:forEach items="${listTujuan}" var="listTujuan">
                                    <c:choose>
                                        <c:when test="${listTujuan.tujuan == order.travelTujuan.tujuan}">
                                            <option value="${listTujuan.idTravelTujuan}" selected>${listTujuan.tujuan}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${listTujuan.idTravelTujuan}">${listTujuan.tujuan}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Charge</td>
                        <td>:</td>
                        <td><input type="text" name="charge" value="${order.travelDetailOrder.charge}" /></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>:</td>
                        <td><select name="status">
                                <c:forEach items="${listStatus}" var="listStatus">
                                    <c:choose>
                                        <c:when test="${listStatus.status == order.statusTravel.status}">
                                            <option value="${listStatus.idStatusTravel}" selected>${listStatus.status}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${listStatus.idStatusTravel}" >${listStatus.status}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center"><input type="submit" value="Edit!" /></td>
                    </tr>
                </form>
                </table></center>
            <div class="clear"></div>
    </div>
      <div id="footer">
          <center>&copy; 2011 CV. VadimTravel</center> </div>
      <!-- end footer -->
  </div><!-- end wrapper -->
</body>
</html>