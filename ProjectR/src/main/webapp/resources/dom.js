const realFileBtn = document.getElementById("real-file");
const custFileBtn = document.getElementById('custom-button');
const custText = document.getElementById('custom-text');

custFileBtn.addEventListener("click", function() {
    realFileBtn.click();
})

realFileBtn.addEventListener('change', function() {
    if (realFileBtn.value){
        custText.innerHTML= realFileBtn.value.match(/[\/\\]([\w\d\s\.\-\(\)]+)$/)[1];
    }else{
        custText.innerHTML = "no file chosen yet";
    }
})
