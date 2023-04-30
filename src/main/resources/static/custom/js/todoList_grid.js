document.addEventListener("DOMContentLoaded", async function(){
	await main();
});


async function main(){
	console.log('use grid ...');
	const Grid = tui.Grid;
	var gridInstance = makeGridInstance(Grid);
	
	var todoList = await getTodoList();  
	console.log('todoList : ', todoList);
	
	gridInstance.resetData(todoList);
	Grid.applyTheme('striped')
	
	
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

