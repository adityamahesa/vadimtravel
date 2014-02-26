<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>vadimTRAVEL :: As Happy As Your Trip</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="jquery/themes/base/jquery.ui.all.css" type="text/css"/>
        <script type="text/javascript" src="../../jquery/jquery-1.4.4.js"></script>
	<script type="text/javascript" src="../../jquery/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="../../jquery/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="../../jquery/ui/jquery.ui.datepicker.js"></script>
        <script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker();
	});
	</script>
</head>
<body>
  <div id="wrapper">
      <h1><a href="index.jsp"><img src="images/logo.gif" width="554" height="47" alt="Vadim Travel" /></a></h1>
      <div id="booking">
          <h2>Kata - kata Mutiara</h2>
            &quot;Orang yang bijak adalah orang yang mampu menahan hawa nafsunya&quot;<br />
			<i>- Prophet Mohammed</i>
    </div><!-- end booking -->
      <div id="nav">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="controller?action=tujuan">Daftar Tujuan</a></li>
          <li><a href="controller?action=booking">Booking</a></li>
          <li><a href="controller?action=about">Tentang Kita</a></li>
        </ul>
    </div><!-- end nav -->
      <!-- end packages -->
<div id="main">
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="447" height="298" title="slogan">
    <param name="movie" value="Untitled-1.swf" />
    <param name="quality" value="high" />
    <embed src="Untitled-1.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="447" height="298"></embed>
  </object>
            <h2><img src="images/title_hottest_locations.gif" width="447" height="24" alt="hottest locations" /></h2>
           <div class="clear"></div>
    </div><!-- end main -->
	<!-- <div class="inner"> -->
	<div class="inner" style="margin-left:100px; margin-right:50px;">
            <center><table><font size="14">
                    <form action="controller?action=bookingprocess" method="post">
                    <tr>
                        <td>Nama</td>
                        <td>:</td>
                        <td><input type="text" name="nama"/></td>
                    </tr>
                    <tr>
                        <td>Alamat</td>
                        <td>:</td>
                        <td><input type="text" name="alamat"/></td>
                    </tr>
                    <tr>
                        <td>Kota</td>
                        <td>:</td>
                        <td><select name="regional" style="width: 100%">
                                <option value="0">Pilih Regional....</option>
                                <c:forEach items="${regional}" var="regional">
                                <option value="${regional.idTravelRegional}">${regional.regional}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Telp</td>
                        <td>:</td>
                        <td><input type="text" name="telp"/></td>
                    </tr>
                    <tr>
                        <td>Tujuan</td>
                        <td>:</td>
                        <td>
                            <c:choose>
                                <c:when test="${getidtujuan != null}">
                                    <input type="hidden" name="tujuan" readonly value="${getidtujuan}"/><b>${gettujuan}</b>
                                </c:when>
                                <c:otherwise>
                                    <select name="tujuan">
                                        <c:forEach items="${tujuan}" var="tujuan">
                                            <option value="${tujuan.idTravelTujuan}">${tujuan.tujuan}</option>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <td>Tanggal Berangkat</td>
                        <td>:</td>
                        <td><input type="text" name="tgl_berangkat" value="yyyy-mm-dd" id="datepicker"/></td>
                    </tr>
                    <tr>
                        <td>Pukul</td>
                        <td>:</td>
                        <td><select name="jam_berangkat">
                                <option value="00:00">00:00</option>
                                <option value="01:00">01:00</option>
                                <option value="02:00">02:00</option>
                                <option value="03:00">03:00</option>
                                <option value="04:00">04:00</option>
                                <option value="05:00">05:00</option>
                                <option value="06:00">06:00</option>
                                <option value="07:00">07:00</option>
                                <option value="08:00">08:00</option>
                                <option value="09:00">09:00</option>
                                <option value="10:00">10:00</option>
                                <option value="11:00">11:00</option>
                                <option value="12:00">12:00</option>
                                <option value="13:00">13:00</option>
                                <option value="14:00">14:00</option>
                                <option value="15:00">15:00</option>
                                <option value="16:00">16:00</option>
                                <option value="17:00">17:00</option>
                                <option value="18:00">18:00</option>
                                <option value="19:00">19:00</option>
                                <option value="20:00">20:00</option>
                                <option value="21:00">21:00</option>
                                <option value="22:00">22:00</option>
                                <option value="23:00">23:00</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="3"><input type="submit" value="order!" /></td>
                    </tr>
                </form>
                    </font>
                </table></center>

            <div class="clear"></div>
    </div>
      <div id="footer">
          &copy; 2011 CV. VadimTravel </div>
      <!-- end footer -->
  </div><!-- end wrapper -->
</body>
</html>