document.addEventListener("DOMContentLoaded", async function(){
	await main();
});


async function main(){
	const Grid = tui.Grid;
	var gridInstance = makeGridInstance(Grid);
	
	console.log('gridInstance : ', gridInstance);
	
	setFocusEvent(gridInstance);
	setHrefToButton("/mk-todo", "bt");
	setRemoveTodoButton("/rmTodo", "bt2", gridInstance);
	
	var todoList = await getTodoList();  
	console.log('todoList : ', todoList);
	
	gridInstance.resetData(todoList);
	Grid.applyTheme('striped');
}

async function getTodoList(){
	var todoList = await fetch('/todoList', {
		method:"POST"
	}).then((response) => response.json());
	
	return todoList.todoListServiceResult;
}

function makeGridInstance(Grid){
	const instance = new Grid({
		el : document.getElementById('grid'),
		columns:[
			{
				header:'할 일',
				name:'task',
				align:'center'
			},
			{
				header:'할당자',
				name:'seniorName',
				align:'center'
			},
			{
				header:'업무 할당일',
				name:'startDate',
				align:'center',
				sortable: true
			},
			{
				header:'마감일',
				name:'deadDate',
				align:'center',
				sortable: true
			},
			{
				header:'중요도',
				name:'importance',
				align:'center',
				sortable: true
			},
			
		]
	});

	return instance;
}

function setFocusEvent(gridInstance){
	gridInstance.on('focusChange', (ev)=>{
		console.log('ev : ', ev);
		gridInstance.setSelectionRange({
			start : [ev.rowKey, 0],
			end : [ev.rowKey, gridInstance.getColumns().length]
		});
	});
}

function setHrefToButton(url, elementId){
	var element = document.getElementById(elementId);
	
	element.addEventListener('click', ()=>{
		location.href=url;
	});
}

async function setRemoveTodoButton(url, elementId, gridInstance){
	var element = document.getElementById(elementId);
	
	element.addEventListener('click', async ()=>{
		var focusedCell = gridInstance.getFocusedCell();
		var focusedRow = gridInstance.getRow(focusedCell.rowKey);
		
		console.log("focusedRow : ", focusedRow);
		
		var requestData = {
			"todoId" : focusedRow.todoId
		};
		
		console.log("requestData : ", requestData);
		
		var deleteCnt = await fetch(url, {
			method:"POST",
			headers: {
				"Accept": "application/json",
				"Content-Type": "application/json",
			},
			body: JSON.stringify(requestData),
		});
		
		location.href="/todoList_grid"
	});
	

}

