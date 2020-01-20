`use strict`;
let newRegister = document.getElementById("newUI");
const poemDisplay = document.querySelector("#newRegister");
const getData = () => {
  return fetch(`http://localhost:8081/projectr/eHome`);
};
getData()
  .then(res => res.json())
  .then(json => {
    let uData = json;
    
      document.getElementById("fName").innerHTML += uData.firstName;
      document.getElementById("lName").innerHTML += uData.lastName;
      document.getElementById("uEmail").innerHTML += uData.email;
      document.getElementById("uUser").innerHTML += uData.username;
      document.getElementById("uPass").innerHTML += uData.password;
    
    
    console.log(json);
  })
  .catch(err => console.error(err));







//let sortDirection = false;
//
//            let personData = [
//            { first : 'dillon', last: 'tree', receipt:24 },
//            { first : 'bianca', last: 'fire', receipt:27 },
//            { first : 'max', last:'raze', receipt:34 },
//            { first : 'alex', last: 'ground', receipt:54 },
//            { first : 'corey', last: 'right', receipt:22 },           
//            ];
//
//            window.addEventListener('load', (e) => {
//                loadTableData(personData);
//            });
//
//function loadTableData(){ 
//    const tableBody = document.getElementById("tableData");  
//    const tableBodyAccepted = document.getElementById("tableDataAccepted");
//    const tableBodyDenied = document.getElementById("tableDataDenied");         
//    let dataHtml = '';
//
//    for (let person of personData){
//        dataHtml += `<tr><td>${person.first}</td><td>${person.last}</td><td>${person.receipt}</td></tr>`;
//    }
//    console.log(dataHtml);
//
//    tableBody.innerHTML = dataHtml;
//    tableBodyAccepted.innerHTML = dataHtml;
//    tableBodyDenied.innerHTML = dataHtml;
//    }