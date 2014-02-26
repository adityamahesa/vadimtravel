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
      
        <div id="main" style="background-color: #f2aa2e; width: 100%; ">
    <h1><a href="index.jsp"><img src="images/logo.gif" width="554" height="47" alt="Vadim Travel" /></a></h1>
    </div><!-- end main -->
	<div class="inner">
            <c:choose>
                <c:when test="${jabatan == 'adm'}">
                    <h2><a href="controller?action=office">Office</a> | <a href="controller?action=operator">Operator</a> | <a href="controller?action=logout">Logout</a></h2>
                </c:when>
                <c:otherwise>
                    <h2><a href="controller?action=office">Office</a> | <a href="controller?action=logout">Logout</a></h2>
                </c:otherwise>
            </c:choose>
            ${msg}
	<!-- <div class="inner" style="margin-left:100px; margin-right:50px; font-size:12px"> -->
       <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                    <th>Regional</th>
                    <th>Telp</th>
                    <th>Tgl Transaksi</th>
                    <th>Tgl Berangkat</th>
                    <th>Jam Berangkat</th>
                    <th>Tujuan</th>
                    <th>Harga Regional</th>
                    <th>Harga Tujuan</th>
                    <th>Charge</th>
                    <th>Total</th>
                    <th>Status</th>
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach items="${list}" var="list">
                    <tr>
                        <td>${list.travelOrder.idTravelOrder}</td>
                        <td>${list.travelOrder.nama}</td>
                        <td>${list.travelOrder.alamat}</td>
                        <td>${list.travelRegional.regional}</td>
                        <td>${list.travelOrder.telp}</td>
                        <td>${list.travelOrder.tglTransaksi}</td>
                        <td>${list.travelOrder.tglBerangkat}</td>
                        <td>${list.travelOrder.jamBerangkat}</td>
                        <td>${list.travelTujuan.tujuan}</td>
                        <td><fmt:formatNumber type="currency" currencySymbol="Rp ">${list.travelRegional.harga}</fmt:formatNumber></td>
                        <td><fmt:formatNumber type="currency" currencySymbol="Rp ">${list.travelTujuan.harga}</fmt:formatNumber></td>
                        <td><fmt:formatNumber type="currency" currencySymbol="Rp ">${list.travelDetailOrder.charge}</fmt:formatNumber></td>
                        <td><fmt:formatNumber type="currency" currencySymbol="Rp ">${list.total}</fmt:formatNumber></td>
                        <td>${list.statusTravel.status}</td>
                        <th><a href="controller?action=editorder&id=${list.travelOrder.idTravelOrder}">Edit</a></th>
                        <th><a href="controller?action=deleteorder&id=${list.travelOrder.idTravelOrder}">Delete</a></th>
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