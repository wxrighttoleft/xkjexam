function menuUp(element) {
	var div1 = document.getElementById("yuan1");
	var div2 = document.getElementById("yuan2");
	var topMenu1 = document.getElementById("employeeAdmin");
	var topMenu2 = document.getElementById("infoAdmin");
	if (element == topMenu1) {
		div1.style.display = "block";
		div2.style.display = "none";
	}
	if (element == topMenu2) {
		div2.style.display = "block";
		div1.style.display = "none";
	}
}