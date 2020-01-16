//let registerForm = document.getElementById('registerForm');
//
//let recipeUri = 'http://localhost:8081/projectr/register'
//
//registerForm.addEventListener('submit', (e) => {
//    //we need to prevent default form bahavior
//    e.preventDefault();
//   sendRegister();
//});
//
//async function sendRegister(){
//    console.log(registerFirstName.value);
//    console.log(registerLastName.value);
//    console.log(registerEmail.value);
//    console.log(registerUsername.value);
//    console.log(registerPassword.value);
//    console.log(registerConfirmPassword.value);
//
//
//    let register ={};
//    register.registerFirstName = registerFirstName.value;
//    register.registerLastName = registerLastName.value;
//    register.registerEmail = registerEmail.value;
//    register.registerUsername = registerUsername.value;
//    register.registerPassword = registerPassword.value;
//    register.registerConfirmPassword = registerConfirmPassword.value;
//
//    console.log(register);
//
//     let response = await fetch('myUri', {method: 'POST', body: 'register'});
//     console.log(response);
//}