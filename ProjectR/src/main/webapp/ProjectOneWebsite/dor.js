let sRequestForm = document.getElementById("sRequestForm");
let employeeAmount = document.getElementById("request-amount");
let sendRequest = document.getElementById("sRequestBtn");

let sendRequestUri = "http://localhost:8081/projectr/sRequest";

sendRequest.addEventListener('click', (event)=>{
    
    console.log('received click');
    event.preventDefault();    
    sendRequestAmount();
});

async function sendRequestAmount() {

    let requestInfo = {};
    requestInfo.id = 0;
    requestInfo.amount = employeeAmount.value;
    requestInfo.decision = ' ';
    requestInfo.manUser = ' ';
    requestInfo.eUser = ' ';
    console.log(requestInfo);

    let response = await fetch(sendRequestUri, {method:'POST',body: JSON.stringify(requestInfo)});
    console.log(response);
    let body = await response.text();
}