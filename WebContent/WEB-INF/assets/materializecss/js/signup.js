//Created / Generates the captcha function

    
    function DrawCaptcha()
    {
        //first we disable the submit button again
        
        document.getElementById('submit').disabled=true;
        var a = Math.ceil(Math.random() * 10)+ '';
        var b = Math.ceil(Math.random() * 10)+ '';       
        var c = Math.ceil(Math.random() * 10)+ '';  
        var d = Math.ceil(Math.random() * 10)+ '';  
        var e = Math.ceil(Math.random() * 10)+ '';  
        var f = Math.ceil(Math.random() * 10)+ '';  
        var g = Math.ceil(Math.random() * 10)+ '';  
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
        document.getElementById("txtCaptcha").value = code;
        
    }

    // Validate the Entered input aganist the generated security code function   
    function ValidCaptcha(){
        var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
        var str2 = removeSpaces(document.getElementById('txtInput').value);
        if (str1 === str2) return true;        
        return false;
        
    }

    // Remove the spaces from the entered and generated code
    function removeSpaces(string)
    {
        return string.split(' ').join('');
    }
    
    function checktel()
    {
        var tel=document.getElementById('telephone').value;
        
        var patt = /^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$/;
        
        if(!patt.test(tel))
            alert("Wrong Contact Number");
    }
    
    function checkpin()
    {
        var tel=document.getElementById('pin_code').value;
        
        var patt = /^\d{6}$/;
        
        if(!patt.test(tel))
            alert("Wrong PINCODE");
    }
    
    function passstrngth()
    {
        var pass=document.getElementById('password').value;
        var patt = new RegExp("[0-9]+");
        var patt1 = new RegExp("[a-z]+");
        var patt2 = new RegExp("[A-Z]+");
        var patt3 = new RegExp("[^0-9|^A-Z|^a-z]+");
        if(pass.length>7 && patt.test(pass)&& patt1.test(pass)&& patt2.test(pass)&& patt3.test(pass))
            document.getElementById('progressbar').style.setProperty("width","100%");
        else if(pass.length>7 && patt1.test(pass)&& patt2.test(pass)&& patt2.test(pass))
            document.getElementById('progressbar').style.setProperty("width","80%");
        else if(pass.length>7 && patt1.test(pass)&& patt2.test(pass))
            document.getElementById('progressbar').style.setProperty("width","60%");
        else if(pass.length>5 && patt1.test(pass))
            document.getElementById('progressbar').style.setProperty("width","40%");
        else if(pass.length>3)
            document.getElementById('progressbar').style.setProperty("width","20%");
        else{
            document.getElementById('progressbar').style.setProperty("width","0%");
            document.getElementById('progressbar').style.setProperty("color","green");
        }
        
    }
    
    function check_pass(){
        
    if ((document.getElementById('password').value===document.getElementById('confirm_password').value)&&ValidCaptcha()){
        
           document.getElementById('submit').disabled = false;           
        }
        else {
        document.getElementById('submit').disabled = true;
        }
    }
    
   
