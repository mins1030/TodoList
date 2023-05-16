document.addEventListener("DOMContentLoaded", async function(){
	await main();
});


async function main(){
	var profileList = await getProfile();  
	console.log('profileList : ', profileList);
	var profile = profileList[0];
	
	makeTable(profile);
}

async function getProfile(){
	var profile = await fetch('/profile', {
		method:"POST"
	}).then((response) => response.json());
	
	
	return profile.profileServiceResult;
}
function makeTable(profile){
	var table = document.querySelector('#profile-table');
	console.log('table : ', table);
	
	var tr1 = document.createElement('tr');
	var tr2 = document.createElement('tr');
	var tr3 = document.createElement('tr');
	var tr4 = document.createElement('tr');
	var tr5 = document.createElement('tr');
	
	var td1 = document.createElement('td');
	td1.innerText = "이름";	
	td1.classList.add("t1");
	var td2 = document.createElement('td');
	td2.innerText = profile.name;
	td2.classList.add("t2");
	
	var td3 = document.createElement('td');
	td3.innerText = "이메일";
	td3.classList.add("t1");	
	var td4 = document.createElement('td');
	td4.innerText = profile.email;
	td4.classList.add("t2");
	
	var td5 = document.createElement('td');
	td5.innerText = "사원번호";	
	td5.classList.add("t1");
	var td6 = document.createElement('td');
	td6.innerText = profile.empNum;
	td6.classList.add("t2");
	
	var td7 = document.createElement('td');
	td7.innerText = "부서";
	td7.classList.add("t1");	
	var td8 = document.createElement('td');
	td8.innerText = profile.dept;
	td8.classList.add("t2");
	
	var td9 = document.createElement('td');
	td9.innerText = "직급";
	td9.classList.add("t1");	
	var td10 = document.createElement('td');
	td10.innerText = profile.pos;
	td10.classList.add("t2");
		
	tr1.appendChild(td1);
	tr1.appendChild(td2);
	tr2.appendChild(td3);
	tr2.appendChild(td4);
	tr3.appendChild(td5);
	tr3.appendChild(td6);
	tr4.appendChild(td7);
	tr4.appendChild(td8);
	tr5.appendChild(td9);
	tr5.appendChild(td10);
		
	table.appendChild(tr1);
	table.appendChild(tr2);
	table.appendChild(tr3);
	table.appendChild(tr4);
	table.appendChild(tr5);
}