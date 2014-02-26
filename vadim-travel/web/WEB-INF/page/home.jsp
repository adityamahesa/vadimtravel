<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>vadimTRAVEL :: As Happy As Your Trip</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
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
	<div class="inner" style="margin-left:100px; margin-right:50px; font-size:12px">
            <c:choose>
                <c:when test="${msg == 'sukses'}">
                    <center><font color="green">TRANSAKSI ANDA BERHASIL</font></center>
                    <p>Terimakasih, anda telah memilih jasa vadimTRAVEL sebagai biro perjalanan pilihan anda!
                    Anda dapat mengkonfirmasikan perjalanan anda melalui Telepon: 085-735-054700, dan kami percayakan anda
                    untuk membayar transaksi pada saat perjalanan anda....<br><br>
                            Sincerely,<br><br>
                                    CV. Vadim Travel</p>
                </c:when>
                <c:otherwise>
                    <p>Selamat Datang di situs pemesanan perjalanan vadimTRAVEL! Kami menyediakan biro perjalanan
                        yang dijamin nyaman, cepat, dan aman. Sebagai petunjuk, anda dapat melihat profil kami di
                    "Tentang Kami". Untuk melihat Daftar Tujuan serta estimasi harga, klik "Tujuan". Atau anda bisa
                    langsung memesan lewat "Booking"</p>
                </c:otherwise>
            </c:choose>

            <div class="clear" style="height: 200px"></div>
    </div>
      <div id="footer">
          &copy; 2011 CV. VadimTravel </div>
      <!-- end footer -->
  </div><!-- end wrapper -->
</body>
</html>
