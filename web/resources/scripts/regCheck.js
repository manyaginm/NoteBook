/**
 * Created by MManiagin on 27.07.2017.
 */
console.log("123214")
var regBtn = document.getElementById("regSubmitBtn");
console.log(regBtn);


regBtn.onclick = function () {
    var userName = document.getElementById("userLoginRegPage");
    var userPass = document.getElementById("userPasswordRegPage");
    var submitPass= document.getElementById("userPasswordSubmitRegPage");
    console.log(userName.value);

    if(userName.value==""){
        document.getElementById("loginErr").textContent="Can not be empty";
        return false;
    }
    if(userPass.value==""){
        document.getElementById("passErr").textContent="Can not be empty";
        return false;
    }
    if(submitPass.value=""){
        document.getElementById("submitPassErr").textContent="Can not be empty";
        return false;
    }
   if(!(userPass.value.localeCompare(submitPass.value))){
        document.getElementById("errSpan").textContent="Passwords must match";
        return false;
    }
    return true
};