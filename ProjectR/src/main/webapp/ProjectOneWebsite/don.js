'use strict'

const getData = () => {
  return fetch(`http://localhost:8081/projectr/eHome`);
};

getData()
  .then(res => res.json())
  .then(json => {
    let uData = json;
    
      document.getElementById("fName").innerHTML += uData.registerFirstName;
      document.getElementById("lName").innerHTML += uData.registerLastName;
      document.getElementById("uEmail").innerHTML += uData.registerEmail;
      document.getElementById("uUser").innerHTML += uData.registerUsername;
      document.getElementById("uPass").innerHTML += uData.registerPassword;
    
    
    console.log(json);
  })
  .catch(err => console.error(err));


let appendRequestUri = "http://localhost:8081/projectr/sRequest";
let viewPending = document.getElementById('viewPending');
let pendingReqs = document.getElementById('pendingReqBtn');;


pendingReqs.addEventListener('click', (event) => {
    event.preventDefault();
    viewPendingInfo();
});

async function viewPendingInfo() {
    let pendingRequests = await fetch(appendRequestUri, { method: 'GET' });
    let pendingReqsText = await pendingRequests.text();
    viewPending.innerHTML = '';

    JSON.parse(pendingReqsText, function (key, value) {
        if (key == "amount") {
            let pRequests = document.createElement('p');
            pRequests.innerText = "$" + value;
            viewPending.appendChild(pRequests);
        }
    });
}

let appendRequestUri = "http://localhost:8081/projectr/eHome";
let viewProc = document.getElementById('viewProc');
let procReqs = document.getElementById('procReqBtn');

procReqs.addEventListener('click', (event) => {
    event.preventDefault();
    viewProcessedInfo();
});

async function viewProcessedInfo() {
    let procRequests = await fetch(appendRequestUri, { method: 'GET' });
    let procReqsText = await procRequests.text();
    viewProc.innerHTML = '';

    JSON.parse(pendingReqsText, function (key, value) {
        if (key == "decision") {
        	if (value == "true"){
            let appRequests = document.createElement('p');
            appRequests.innerText = "$" + amount.value + " Reimbursement Approved";
            viewProc.appendChild(appRequests);
        	} else if (value == "false"){
        		let denRequests = document.createElement('p');
                denRequests.innerText = "$" + amount.value + " Reimbursement Denied";
                viewProc.appendChild(denRequests);        		
        	}
        }
    });
}