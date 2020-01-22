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



