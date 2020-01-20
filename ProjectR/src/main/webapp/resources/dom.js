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
//
//let sortDirection = false;
//
//            let personData = [
//            { receipt:24 },
//            { receipt:27 },
//            { receipt:34 },
//            { receipt:54 },
//            { receipt:22 },           
//            ];
//
//            window.addEventListener('load', (e) => {
//                loadTableData(personData);
//            });
//
//function loadTableData(){ 
//     
//    const tableBodyAccepted = document.getElementById("tableDataAccepted");
//    const tableBodyDenied = document.getElementById("tableDataDenied");    
//    const tableBodyPending = document.getElementById("tableDataPending");  
//    let dataHtml = '';
//
//    for (let person of personData){
//        dataHtml += `<tr><td>${person.receipt}</td></tr>`;
//    }
//    console.log(dataHtml);
//
//    
//    tableBodyAccepted.innerHTML = dataHtml;
//    tableBodyDenied.innerHTML = dataHtml;
//    tableBodyPending.innerHTML = dataHtml;
//    }

   

