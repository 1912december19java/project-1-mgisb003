'use strict'

let appendedRequestUri = "http://localhost:8081/projectr/rRequest";
let viewPend = document.getElementById('viewPendingM');
let pendReqs = document.getElementById('pendingReqBtn');


pendReqs.addEventListener('click', (event)=>{
    event.preventDefault();
    pendingReqs();
});


async function pendingReqs() {
    let pendingReqs = await fetch(appendedRequestUri, { method: 'GET' });
    let reqs = await pendingReqs.text();
    let obj = {};
    viewPend.innerHTML = '';

    JSON.parse(reqs, function (key, value) {

        if (key == "id") {
            obj.id = value;
        } else if (key == "eUser") {
            obj.eUser = value;
        } else if (key == "blob") {
            obj.blob = value;
        } else if (key == "decision") {
            obj.decision = value;
        } else if (key == "manUser") {
            obj.manUser = value;
        } else if (key == "amount") {
            obj.amount = value;
        }
        console.log(Object.keys(obj).length);
        if (Object.keys(obj).length == 6) {
        	console.log("creating Element");
            let reqInfo = document.createElement('p');
            reqInfo.setAttribute('id',`column ${obj.id}`);
            reqInfo.innerText = "Request: $" + obj.amount + " Employee: " + obj.blob;
            viewPend.appendChild(reqInfo);
            
            let approve = document.createElement('button');
            approve.setAttribute('class', 'btn btn-success');
            approve.innerText = "Approve";
            viewPend.appendChild(approve);

            let deny = document.createElement('button');
            deny.setAttribute('class', 'btn btn-danger');
            deny.innerText = "Deny";
            viewPend.appendChild(deny);
            obj = {};
        }
    });
}
