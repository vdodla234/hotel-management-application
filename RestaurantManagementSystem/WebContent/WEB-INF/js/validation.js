/**
 * 
 */
$(function() {
        $( ".datepicker" ).datepicker({dateFormat: "dd-mm-yy"});
      });
    $(function() {
        $( ".datepicker2" ).datepicker({dateFormat: "dd-mm"});
      });
    $(function() {
        $( ".datepicker1" ).datepicker({dateFormat: "M - yy"});
      });
    $(function() {
        $( ".datepickeryear" ).datepicker({dateFormat: "yy"});
      });
    
    /*ended*/

function validateJobApplication(){
	alert("hi");
	 var a = document.getElementById("fullname").value;
     var c = document.getElementById("dob").value;
     var d = document.getElementById("education").value;
     var e = document.getElementById("experience").value;
     var f = document.getElementById("phoneNo").value;
     var g = document.getElementById("address").value;
     var h = document.getElementById("skills").value;
     
     if(a==null||a==""||a==" "){$("#a1").html("enter your name").show();}else{$("#a1").hide();}
     if(c==null||c==""||c==" "){$("#a3").html("enter date of birth").show();}else{$("#a3").hide();}
     if(d==null||d==""||d==" "){$("#a4").html("enter your degree qualification").show();}else{$("#a4").hide();}
     if(e==null||e==""||e==" "){$("#a5").html("enter experience").show();}else{$("#a5").hide();}
     if(f==null||f==""||f==" "){$("#a6").html("enter phone number").show();}else{$("#a6").hide();}
     if(g==null||g==""||g==" "){$("#a7").html("enter Address").show();}else{$("#a7").hide();}
     if(h==null||h==""||h==" "){$("#a8").html("select skills/achievements").show();}else{$("#a8").hide();}
     var radios = document.getElementsByName("jobtype");
     var formValid = false;

     var i = 0;
     while (!formValid && i < radios.length) {
         if (radios[i].checked) formValid = true;
         i++;        
     }
     if(!formValid){$("#a8").html("select skills/achievements").show();}else{$("#a8").hide();}
     if(a==null||a==""||a==" "||c==null||c==""||c==" "||d==null||d==""||d==" "||e==null||e==""||e==" "||f==null||f==""||f==" "||g==null||g==""||g==" "||h==null||h==""||h==" "||!formValid)
     	{return false;}
     else
     	{return true;}	
}