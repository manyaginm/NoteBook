/**
 * Created by MManiagin on 24.07.2017.
 */
console.log("hello");


var btn = document.getElementById("submitBtn");

btn.onclick = function () {
    var login = document.getElementById("userLogin");
    var pass = document.getElementById("userPassword");


        if (login.value==""){
            console.log("login empty");
            document.getElementById("userError").textContent="can not be empty";
            return false;
        }
        else if(pass.value==""){
            console.log("password empty");
            document.getElementById("passwordError").textContent="can not be empty";
            return false;
        }

        return true;

};