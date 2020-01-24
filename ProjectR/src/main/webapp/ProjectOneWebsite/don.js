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
