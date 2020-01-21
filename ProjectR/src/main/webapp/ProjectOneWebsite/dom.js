'use strict'


const getData = () => {
  return fetch(`http://localhost:8081/projectr/mHome`);
};
getData()
  .then(res => res.json())
  .then(json => {
    let uData = json;
    
      document.getElementById("mUser").innerHTML += uData.managerUsername;
      document.getElementById("mPass").innerHTML += uData.managerPassword;
    
    
    console.log(json);
  })
  .catch(err => console.error(err));



let personData = [
{ first : 'Bill', last: 'Gates', receipt:24 },
{ first : 'Bill', last: 'Nye', receipt:27 },
{ first : 'Bill', last:'Jackson', receipt:34 },
{ first : 'Bill', last: 'Ding', receipt:54 },
{ first : 'Buffalo', last: 'Bill', receipt:22 }, 
{ first : 'Bill', last: 'Thorne', receipt:24 },
{ first : 'Bill', last: 'Bill', receipt:27 },
{ first : 'Bill', last:'Japan', receipt:34 },
{ first : 'Bill', last: 'Montgomery', receipt:54 },
{ first : 'Bill', last: 'Name', receipt:22 }, 
];

window.addEventListener('load', (e) => {
    loadTableData(personData);
});

function loadTableData(){ 
const tableBody = document.getElementById("tableData");  
const tableBodyAccepted = document.getElementById("tableDataAccepted");
const tableBodyDenied = document.getElementById("tableDataDenied");
const tableBodyEmployee = document.getElementById("tableDataEmployee");       
let dataHtml = '';
let employeeHTML = '';

for (let person of personData){
employeeHTML += `<tr><td>${person.first}</td><td>${person.last}</td></tr>`;
}

for (let person of personData){
dataHtml += `<tr><td>${person.first}</td><td>${person.last}</td><td>${person.receipt}</td></tr>`;
}
console.log(dataHtml);

tableBody.innerHTML = dataHtml;
tableBodyAccepted.innerHTML = dataHtml;
tableBodyDenied.innerHTML = dataHtml;
tableBodyEmployee.innerHTML = employeeHTML;
}