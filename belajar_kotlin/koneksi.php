<?php
	/**
	nama file : koneksi.php
	developer : Alexander Paimo
	Company	  : kelompok Mawar
*/
//koneksi ke db
$con = mysqli_connect("localhost","root","","belajar_kotlin");

//cek koneksi
If(mysqli_connect_error()){
echo "failed to konek ".mysqli_connect_error();
}

	

?>