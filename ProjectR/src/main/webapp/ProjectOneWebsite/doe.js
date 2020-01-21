let eUpdateForm = document.getElementById("updateFormE");
let employeePassword = document.getElementById("update-password");
let employeeFirstName = document.getElementById("update-first-name");
let employeeLastName = document.getElementById("update-last-name");
let employeeEmail = document.getElementById("update-email");
let employeeSubmit = document.getElementById("updateUI");

let updateInfoUri = "http://localhost:8081/projectr/eHome";

employeeSubmit.addEventListener('click', (event)=>{
	console.log('received click');
    event.preventDefault();
    UpdateUserInfo();
});

async function UpdateUserInfo() {

    let updatedInfo = {};
    updatedInfo.registerFirstName = employeeFirstName.value;
    updatedInfo.registerLastName = employeeLastName.value;
    updatedInfo.registerPassword = employeePassword.value;
    updatedInfo.registerEmail = employeeEmail.value;

    console.log(updatedInfo);

    let response = await fetch(updateInfoUri, {method:'POST',body: JSON.stringify(updatedInfo)});
    console.log(response);
    let body = await response.text();
}