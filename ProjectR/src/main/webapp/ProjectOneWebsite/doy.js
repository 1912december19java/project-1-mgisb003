let employeeList = document.getElementById('viewEmpM');
let showEmployed = document.getElementById('VempBtn');
let employedUri = "http://localhost:8081/projectr/vEmployed";

showEmployed.addEventListener('click', (event)=>{
	console.log('received click');
	event.preventDefault(); 
	getEmployees();
	
});

async function getEmployees() {
	
    let showEmp = await fetch(employedUri, { method: 'GET' });
    let empList = await showEmp.text();
    employeeList.innerHTML = '';

    JSON.parse(empList, function (key, value) {

        if (key == "registerUsername" ) {
            let Emp = document.createElement('li');
            Emp.className = 'employee-list';
            Emp.setAttribute('id',`${value}`);
            Emp.innerText = value;
            employeeList.appendChild(Emp);
        }
    });
}