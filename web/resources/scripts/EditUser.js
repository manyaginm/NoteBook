/**
 * Created by MManiagin on 01.08.2017.
 */
var modal = document.getElementById("myModal");
var radios = document.getElementsByName('contactGroup');
var span= document.getElementsByClassName("close")[0];
var cancelButton = document.getElementById("editCancel");


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

