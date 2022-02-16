
/*
axios.get("http://site.api.espn.com/apis/site/v2/sports/soccer/eng.1/scoreboard").then(function (response) {
    console.log(response);
}).catch(function (error) {
    console.log("error", error);
}).then(function() {

});
*/
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        events: [
            {
                title: 'event1',
                start: '2022-02-10'
            },
            {
                title: 'event2',
                start: '2022-01-10',
                end: '2022-02-01'
            },
            {
                title: 'event3',
                start: '2022-02-05T12:30:00',
                allDay: false
            }
        ]
    });
    calendar.render();
});