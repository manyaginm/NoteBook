/**
 * Created by MManiagin on 01.08.2017.
 */
var modal = document.getElementById("myModal");
var radios = document.getElementsByName('contactGroup');
var span= document.getElementsByClassName("close")[0];
var cancelButton = document.getElementById("editCancel");
var searchField = document.getElementById("search");


$("#editBtn").click(function () {
    var jsonObj;
    for (var i = 0; i < radios.length; i++) {
        if (radios[i].type === 'radio' && radios[i].checked) {
            var jsonObj = radios[i].value;
        }
    };
    if(jsonObj===null){
        return;
    }else{
    var obj =JSON.parse(jsonObj);
    console.log(obj.firstName);
    document.getElementById("editId").value=obj.id;
    document.getElementById("editFirstName").value=obj.firstName;
    document.getElementById("editMiddleName").value=obj.middleName;
    document.getElementById("editLastName").value=obj.lastName;
    document.getElementById("editMobilePhoneNumber").value=obj.mobilePhoneNumber;
    document.getElementById("editHomePhoneNumber").value=obj.homePhoneNumber;
    document.getElementById("editWorkPhoneNumber").value=obj.workPhoneNumber;
    document.getElementById("editEmail").value=obj.email;
    document.getElementById("editGroup").value=obj.group;
    modal.style.display='block';}
});
$("#createBtn").click(function () {
    document.getElementById("submitChange").textContent = "Save";
    document.getElementById("submitChange").formAction = "saveContact";
    modal.style.display='block';
});
cancelButton.onclick = function () {
    modal.style.display='none';
}
span.onclick = function () {
    modal.style.display='none';
}
searchField.onkeyup=function () {
    var filter = searchField.value.toUpperCase();
    var contactsInfo = document.getElementsByClassName("contactInfo")
    var cntcFN= document.getElementsByClassName("contactFirstName");
    var cntcMN = document.getElementsByClassName("contactMiddleName");
    var cntcLN = document.getElementsByClassName("contactLastName");
    for(var i =0; i<contactsInfo.length; i++){
        var strToCheck = cntcFN[i].textContent+" "+cntcMN[i].textContent+" "+cntcLN[i].textContent;
        var parent = cntcFN[i].parentNode;
        if(strToCheck.toUpperCase().indexOf(filter)>-1) {
            parent.style.display = "";
        }else{
            parent.style.display = "none";
        }
    }
}