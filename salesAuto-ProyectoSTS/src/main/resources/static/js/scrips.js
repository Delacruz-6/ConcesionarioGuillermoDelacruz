//Deslizamiento del menu lateral
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});

//Blindamos al evento submit del elemento formulario la función de validación


function validate(val) {
    v1 = document.getElementById("marca");
    v2 = document.getElementById("modelo");
    v3 = document.getElementById("categoria");
    v4 = document.getElementById("cambio");
    v5 = document.getElementById("consumo");
    v6 = document.getElementById("cv");
    v7 = document.getElementById("co2");
    v8 = document.getElementById("precio");
    v9 = document.getElementById("foto");
    
    flag1 = true;
    flag2 = true;
    flag3 = true;
    flag4 = true;
    flag5 = true;
    flag6 = true;
    flag7 = true;
    flag8 = true;
    flag9 = true;
    
    if(val>=1 || val==0) {
    if(v1.value == "") {
    v1.style.borderColor = "red";
    flag1 = false;
    }
    else {
    v1.style.borderColor = "green";
    flag1 = true;
    }
    }
    
    if(val>=2 || val==0) {
    if(v2.value == "") {
    v2.style.borderColor = "red";
    flag2 = false;
    }
    else {
    v2.style.borderColor = "green";
    flag2 = true;
    }
    }
    if(val>=3 || val==0) {
    if(v3.value == "") {
    v3.style.borderColor = "red";
    flag3 = false;
    }
    else {
    v3.style.borderColor = "green";
    flag3 = true;
    }
    }
    if(val>=4 || val==0) {
    if(v4.value == "") {
    v4.style.borderColor = "red";
    flag4 = false;
    }
    else {
    v4.style.borderColor = "green";
    flag4 = true;
    }
    }
    if(val>=5 || val==0) {
    if(v5.value == "") {
    v5.style.borderColor = "red";
    flag5 = false;
    }
    else {
    v5.style.borderColor = "green";
    flag5 = true;
    }
    }
    if(val>=6 || val==0) {
    if(v6.value == "") {
    v6.style.borderColor = "red";
    flag6 = false;
    }
    else {
    v6.style.borderColor = "green";
    flag6 = true;
    }
    }
    if(val>=7 || val==0) {
    if(v7.value == "") {
    v7.style.borderColor = "red";
    flag7 = false;
    }
    else {
    v7.style.borderColor = "green";
    flag7 = true;
    }
    }
    if(val>=8 || val==0) {
    if(v8.value == "") {
    v8.style.borderColor = "red";
    flag8 = false;
    }
    else {
    v8.style.borderColor = "green";
    flag8 = true;
    }
    }

    
    flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8;
    
    return flag;
    }