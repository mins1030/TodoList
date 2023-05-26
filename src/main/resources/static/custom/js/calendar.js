document.addEventListener("DOMContentLoaded", async function(){
	await main();
});


async function main(){
	const calendar = makeCalendar('#calendar', getCalendarOptions());
	
	var eventList = await getEventList();
	console.log('eventList : ', eventList);
	
	var calList = makeCalList(eventList);
	console.log('calList : ', calList);
	
	calendar.createEvents(calList);
	
	setHrefToButton("/memo", "bt3");	// 버튼에 화면이동 연결
	
	/*calendar.createEvents([
	  {
	    id: '1',
	    calendarId: '1',
	    title: 'my event',
	    category: 'time', // 'milestone', 'task', 'time' and 'allday'
	    dueDateClass: '',
	    start: '2023-05-18T22:30:00+09:00',
	    end: '2023-05-19T02:30:00+09:00',
	  },
	  {
	    id: '3',
	    calendarId: '1',
	    title: 'second event',
	    category: 'time',
	    dueDateClass: '',
	    start: '2023-05-20T17:30:00+09:00',
	    end: '2023-05-22T17:31:00+09:00',
	  },
	]);*/
}
async function getEventList(){
	var eventList = await fetch('/calendarList', {
		method:"POST"
	}).then((response) => response.json());
	
	return eventList.calListServiceResult;
}
function makeCalendar(querySelector, options){
	const Calendar = tui.Calendar;
	return new Calendar(querySelector, options);
}

function getCalendars(){
	const calendars = [
		{
		    id: '1',
		    name: 'Memo',
		    color: '#ffffff',
		    borderColor: '#9e5fff',
		    backgroundColor: '#9e5fff',
		    dragBackgroundColor: '#9e5fff',
		  },
		  {
		    id: '2',
		    name: 'Work',
		    color: '#ff0000',
		    borderColor: '#00a9ff',
		    backgroundColor: '#00a9ff',
		    dragBackgroundColor: '#00a9ff',
		  },		  
	];
	
	return calendars;
	
}

function getCalendarOptions(){
	return {
		defaultView: 'month',
		calendars:getCalendars(),
		useFormPopup: true,
  		useDetailPopup: true,
  		gridSelection:{
			  enableClick:true
		}
	};
}

function makeCalList(eventList){
	var calList = [];
	
	for(var i=0; i<eventList.length; i++){
		var tmpObj={};
		
		tmpObj["id"]=eventList[i]["id"];
		tmpObj["calendarId"]=eventList[i]["calId"];
		tmpObj["title"]=eventList[i]["title"];
		tmpObj["category"]=eventList[i]["category"];
		tmpObj["dueDateClass"]=eventList[i]["dueDateClass"];
		tmpObj["start"]=eventList[i]["calStart"];
		tmpObj["end"]=eventList[i]["calEnd"];
		
		calList.push(tmpObj);
		
	}
	return calList;
}
function setHrefToButton(url, elementId){
	var element = document.getElementById(elementId);
	
	element.addEventListener('click', ()=>{
		location.href=url;
	});
}
