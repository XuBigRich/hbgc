/*检查邮箱*/
function checkEm(){
    var em=document.getElementById("em");
    var q3=/^[a-zA-Z0-9_]{3,}@[a-zA-Z0-9]+.[a-z]{3}$/
    if(!q3.test(em.value)){
        em.style.borderColor="red";
        document.getElementById("em").value="";
    }
    else{em.style.borderColor="black";}
}
/*检查手机号*/
function checkMob(){
    var mob=document.getElementById("mob");
    var q4=/^1\d{10}$/
    if(!q4.test(mob.value)){
        mob.style.borderColor="red";
        document.getElementById("mob").value="";
    }
    else{mob.style.borderColor="black";}
}
/*检查是否填写完整*/
function test(){
    var fa=document.frm.all;
    for(i=0;i<fa.length;i++){
        if(fa[i].value==""){
            alert("请填写完整");
            return false;
        }
    }
    return true;
}