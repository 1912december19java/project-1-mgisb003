'use strict'

let pReqUriE = "http://localhost:8081/projectr/pReqE";
let viewProcReqE = document.getElementById('viewProcE');
let seeProcReqsE = document.getElementById('procReqBtnE');


seeProcReqsE.addEventListener('click', (event)=>{
    event.preventDefault();
    procReqsE();
});


async function procReqsE() {
    let processedReqsE = await fetch(pReqUriE, { method: 'GET' });
    let PreqsE = await processedReqsE.text();
    let ob = {};
    viewProcReqE.innerHTML = '';

    JSON.parse(PreqsE, function (key, value) {

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
            
            viewProcReqE.appendChild(pReqInfo);
            ob = {}; 
            
        	}else if(ob.decision == false){
        		let pReqInfo = document.createElement('p');
                pReqInfo.setAttribute('id',`column ${ob.id}`);
                pReqInfo.innerText = "Request: $" + ob.amount + " Employee: " + ob.blob + " Denied by: " + ob.manUser;
                console.log(pReqInfo);
                viewProcReqE.appendChild(pReqInfo);
                
                ob = {};
        	}
        	}       
    });
}
