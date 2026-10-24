// Clock
function updateClock() {
  const now = new Date();
  document.getElementById('clock').innerText = now.toLocaleTimeString();
}
setInterval(updateClock, 1000);
updateClock();

// Calendar
const date = new Date();
document.getElementById('calendar').innerText =
  date.toDateString();

// Terminal cursor blink
setInterval(() => {
  const cursor = document.getElementById('cursor');
  cursor.style.visibility = cursor.style.visibility === 'hidden' ? 'visible' : 'hidden';
}, 500);
