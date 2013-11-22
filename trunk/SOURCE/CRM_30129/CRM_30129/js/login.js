function getRequest(){
	var req = false;
	if(window.ActiveXObject){
		try{
			req = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){}
		}
	}else{
		req = new XMLHttpRequest();
	}
	return req;
}
function LoginYan(){
	var loginName = document.getElementById("account").value;
	var loginPwd = document.getElementById("accountPwd").value;
	var yan = document.getElementById("yzmText");
	var img = document.getElementById("yzImg");
	var lbl = document.getElementById("lbl");
	if(loginName.length <=0 || loginPwd.leng<=0 || yan.length <= 0){
		alert("请填写完整");
		img.src = "yzm.pd?aa="+Math.random();
		return false;
	}
	if(lbl.style.color == "red"){
		alert("验证码错误，请重新填写验证码");
		yan.value = "";
		img.src = "yzm.pd?aa="+Math.random();
		return false;
	}
	return true;
}

function YZMYan(a){
	var req = getRequest();
	var bo = false;
	var img = document.getElementById("yzImg");
	var lbl = document.getElementById("lbl");
	req.onreadystatechange = function(){
		if(req.readyState == 4){
			if(req.status == 200){
				var result = req.responseText;
				if(result == "true"){
					lbl.style.color = "#00ff00";
					lbl.innerHTML = "验证码正确";
					bo = true;
				}else if(result =="false"){
					lbl.style.color = "red";
					lbl.innerHTML = "验证码错误";
					img.src = "yzm.pd?aa="+Math.random();
				}
			}
		}
	}
	var url = "CAPTCHAEfficacy.pd?yzmText="+a;
	req.open("GET",url,true);
	req.send(null);
	return bo;
}