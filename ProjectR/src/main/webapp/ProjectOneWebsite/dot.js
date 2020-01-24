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
        	
            let reqInfo = document.createElement('p');
            reqInfo.setAttribute('id',`column ${obj.id}`);
            reqInfo.innerText = "Request: $" + obj.amount + " Employee: " + obj.blob;
            viewPend.appendChild(reqInfo);
            
            let approve = document.createElement('button');
            approve.setAttribute('class', 'btn btn-success');
            approve.setAttribute('type','submit');
            approve.setAttribute('data-dismiss','modal');
            approve.setAttribute('id', `decisionA ${obj.id}`);
            approve.setAttribute('onClick', 'choice(this.id)');
            approve.innerText = "Approve";
            viewPend.appendChild(approve);

            let deny = document.createElement('button');
            deny.setAttribute('class', 'btn btn-danger');
            deny.setAttribute('type','submit');
            deny.setAttribute('data-dismiss','modal');
            deny.setAttribute('id',`decisionD ${obj.id}`);
            deny.setAttribute('onClick','choice(this.id)')
            deny.innerText = "Deny";
            viewPend.appendChild(deny);
            obj = {};
        }
    });
}

async function choice (decision) {
    let str = decision.match(/\d+/g).map(Number);
    Number(str);
    let e;
    let obj = {};
    obj.id = parseInt(str);
    obj.amount = 0;
    obj.decision = '';
    obj.manUser = '';
    obj.blob = '';
    obj.eUser = '';

    if (choice === `choice ${str}`) {
    	obj.decision = false;        
    } else{
        obj.decision = true;
    }

    console.log(obj);
    let resp = await fetch(appendedRequestUri, {method: 'POST', body: JSON.stringify(obj)});
    
    if (resp.status == 200) {
        let e = document.getElementById(`column ${str}`);
        console.log(e);
        let f = document.getElementById(`decisionA ${str}`);
        console.log(f);
        let g = document.getElementById(`decisionD ${str}`);
        console.log(g);
        g.remove();
        f.remove();
        e.remove();
    }
}

let pReqUri = "http://localhost:8081/projectr/pReq";
let viewProcReq = document.getElementById('viewProcM');
let seeProcReqs = document.getElementById('procReqBtn');


seeProcReqs.addEventListener('click', (event)=>{
    event.preventDefault();
    procReqs();
});


async function procReqs() {
    let processedReqs = await fetch(pReqUri, { method: 'GET' });
    let Preqs = await processedReqs.text();
    let ob = {};
    viewProcReq.innerHTML = '';

    JSON.parse(Preqs, function (key, value) {

        if (key == "id") {
            ob.id = value;
        } else if (key == "eUser") {
            ob.eUser = value;
        } else if (key == "blob") {
            ob.blob = value;
        } else if (key == "decision") {
            ob.decision = value;
        } else if (key == "manUser") {
            ob.manUser = value;
        } else if (key == "amount") {
            ob.amount = value;
        }
        console.log(Object.keys(ob).length);
        if (Object.keys(ob).length == 6 ) {
        	
        	
        	
        	if (ob.decision == true){
        	let pReqInfo = document.createElement('p');
            pReqInfo.setAttribute('id',`column ${ob.id}`);
            console.log(pReqInfo);
            pReqInfo.innerText = "Request: $" + ob.amount + " Employee: " + ob.blob + " Approved by: " + ob.manUser;
            
            viewProcReq.appendChild(pReqInfo);
            ob = {}; 
            
        	}else if(ob.decision == false){
        		let pReqInfo = document.createElement('p');
                pReqInfo.setAttribute('id',`column ${ob.id}`);
                pReqInfo.innerText = "Request: $" + ob.amount + " Employee: " + ob.blob + " Denied by: " + ob.manUser;
                console.log(pReqInfo);
                viewProcReq.appendChild(pReqInfo);
                
                ob = {};
        	}
        	}       
    });
}