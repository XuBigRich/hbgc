    function showTime() {
        var t=new Date();
        var y=t.getFullYear();
        var m=t.getMonth()+1;
        var d=t.getDate();
        var h=t.getHours();
        var ms=t.getMinutes();
        var s= t.getSeconds();
        var day=t.getDay();
        var a=["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
        document.getElementById("t5").innerText="当前时间:"+y+"年"+m+"月"+d+"日 "+h+":"+ms+":"+s+" "+a[day];
    }
