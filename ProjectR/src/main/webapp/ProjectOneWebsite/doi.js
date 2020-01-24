'use strict'

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
