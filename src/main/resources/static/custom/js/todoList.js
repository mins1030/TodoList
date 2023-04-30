document.addEventListener("DOMContentLoaded", async function(){
	await main();
});


async function main(){
	var todoList = await getTodoList();  
	console.log('todoList : ', todoList);
	
	makeTable(todoList);
}

async function getTodoList(){
	var todoList = await fetch('/todoList', {
		method:"POST"
	}).then((response) => response.json());
	
	return todoList.todoListServiceResult;
}
function makeTable(todoList){
	var tbody = document.querySelector('#index-tbody');
	
	for(var i=0; i<todoList.length; i++){
		var tr = document.createElement('tr');
		
		var td1 = document.createElement('td');
		td1.innerText = todoList[i].task;
		
		var td2 = document.createElement('td');
		td2.innerText = todoList[i].seniorName;
		td2.classList.add("d-none", "d-xl-table-cell");
		
		var td3 = document.createElement('td');
		td3.innerText = todoList[i].startDate;
		td3.classList.add("d-none", "d-xl-table-cell");
		
		var td4 = document.createElement('td');
		td4.innerText = todoList[i].deadDate;
		td4.classList.add("d-none", "d-xl-table-cell");
		
		var td5 = document.createElement('td');
		td5.innerText = todoList[i].importance;
		
/*		var span = document.createElement('span');
		span.innerText = todoList[i].importance;
		span.classList.add("badge", "bg-info");
		td5.appendChild(span);*/
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		
		tbody.appendChild(tr);
		
	}
	
}

