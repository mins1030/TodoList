document.addEventListener("DOMContentLoaded", async function(){
	await main();
});


async function main(){
	console.log("Gantt : ", Gantt);
	
	var todoList = await getTodoList();  // db에 있는 todoList 가져오기
	console.log('todoList : ', todoList);
	
	var taskList = makeTaskList(todoList);
	console.log('taskList : ', taskList);
	
	var gantt = makeGanttChart("#gantt", taskList, getOptions());
	
	setViewModeEventToButton(gantt, "bt1", "Day");
	setViewModeEventToButton(gantt, "bt2", "Week");
	setViewModeEventToButton(gantt, "bt3", "Month");
	
	
}

function setViewModeEventToButton(gantt, id, mode){
	var btn = document.getElementById(id);
	
	btn.addEventListener('click', ()=>{
		gantt.change_view_mode(mode)
	});
}

function getOptions(){
	return 	{
	    header_height: 50,
	    column_width: 30,
	    step: 24,
	    view_modes: ['Quarter Day', 'Half Day', 'Day', 'Week', 'Month'],
	    bar_height: 20,
	    bar_corner_radius: 3,
	    arrow_curve: 5,
	    padding: 18,
	    view_mode: 'Month',
	    date_format: 'YYYY-MM-DD',
	    language: 'es', // or 'es', 'it', 'ru', 'ptBr', 'fr', 'tr', 'zh', 'de', 'hu'
	    custom_popup_html: null
	}
}

function makeGanttChart(id, taskList, options){
	return new Gantt(id, taskList,options
	);
}

async function getTodoList(){
	var todoList = await fetch('/todoList', {
		method:"POST"
	}).then((response) => response.json());
	
	return todoList.todoListServiceResult;
}

function makeTaskList(todoList){
	var taskList = [];
	
	for(var i=0; i<todoList.length; i++){
		var tempObject = {};
		
		tempObject["id"] = todoList[i]["todoId"];
		tempObject["name"] = todoList[i]["task"];
		tempObject["start"] = todoList[i]["startDate"];
		tempObject["end"] = todoList[i]["deadDate"];
		
		taskList.push(tempObject);
	}
	
	return taskList;
}