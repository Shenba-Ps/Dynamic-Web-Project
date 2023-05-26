


function validateInputs(){
	debugger;
	const firstname = document.getElementById('firstname');
	const firstnameValue = firstname.value.trim();
	let success=true;
	
	if(firstnameValue == ''){
		document.getElementById('firstnameerr').innerHTML="test";
		alert("print")
	}
	else{
		alert("test")
	}
	}