// Clock update
function updateClock() {
  const now = new Date();
  document.getElementById('clock').innerText = now.toLocaleTimeString();
}
setInterval(updateClock, 1000);
updateClock();

// Calendar display
const today = new Date();
document.getElementById('calendar').innerText = today.toDateString();

// Terminal cursor blink
setInterval(() => {
  const cursor = document.getElementById('cursor');
  cursor.style.visibility = cursor.style.visibility === 'hidden' ? 'visible' : 'hidden';
}, 500);

// Basic terminal input (expand yourself)
document.addEventListener('keydown', (e) => {
  const term = document.querySelector('.terminal p');
  if (e.key.length === 1) term.innerHTML += e.key;
  if (e.key === 'Enter') term.innerHTML += '<br>hydro@user:~$ ';
});
