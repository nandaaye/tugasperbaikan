<?php
require_once 'koneksi.php';

$idFakultas = $_POST['id_fakultas'];

if (!$idFakultas) {
    echo json_encode(array('message' => 'required filed is empety.'));
} else {
    $query = mysqli_query($con, "DELETE FROM fakultas WHERE id_fakultas='$idFakultas'");

    if ($query) {
        echo json_encode(array('message' => 'fakultas data successfully DELETE.'));
    } else {
        echo json_encode(array('message' => 'fakultas data Failid DELETE.'));
    }
}

?>
//?>