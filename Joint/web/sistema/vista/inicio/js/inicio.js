function continuar(){
    var conexion;
    if (window.XMLHttpRequest){
        conexion=new XMLHttpRequest();
    }else{
        conexion=new ActiveXObject("Microsoft.XMLHTTP");
    }
    conexion.onreadystatechange=function(){
        if (conexion.readyState===4 && conexion.status===200){
            document.getElementById("row-principal").innerHTML=conexion.responseText;
        }
    }
    conexion.open("POST","RespuestaColores",true);
    conexion.send();
}
function guardarColor(str){
    var color=str;
    var noEmpleado=document.getElementById("noEmpleado").value;
    var conexion;
    if (window.XMLHttpRequest){
        conexion=new XMLHttpRequest();
    }else{
        conexion=new ActiveXObject("Microsoft.XMLHTTP");
    }
    conexion.onreadystatechange=function(){
        if (conexion.readyState===4 && conexion.status===200){
            document.getElementById("respuesta-color").innerHTML=conexion.responseText;
        }
    }
    conexion.open("POST","GuardarColor?noEmpleado="+noEmpleado+"&color="+color,true);
    conexion.send();
}