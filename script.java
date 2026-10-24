/* =====================================
   HYDRO OS — JAVASCRIPT SYSTEM
   ===================================== */

// Helper function
const $ = id => document.getElementById(id);


// 1. LIVE CLOCK AND DATE

function updateTime() {
    const now = new Date();

    const time = now.toLocaleTimeString([], {
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit"
    });

    const date = now.toLocaleDateString([], {
        weekday: "short",
        month: "short",
        day: "numeric"
    });

    // Taskbar clock
    const taskbarClock = $("clock");

    if (taskbarClock) {
        taskbarClock.innerHTML = `${time}<br>${date}`;
    }

    // Clock application
    const bigClock = $("bigClock");
    const bigDate = $("bigDate");

    if (bigClock) bigClock.textContent = time;

    if (bigDate) {
        bigDate.textContent = now.toLocaleDateString([], {
            weekday: "long",
            year: "numeric",
            month: "long",
            day: "numeric"
        });
    }
}

updateTime();
setInterval(updateTime, 1000);


// 2. APPLICATION WINDOW SYSTEM

function closeApps() {
    document.querySelectorAll(".window").forEach(window => {
        window.style.display = "none";
    });
}

function openApp(id) {
    const app = $(id);

    if (!app) {
        console.warn("Application not found:", id);
        return;
    }

    closeApps();

    app.style.display = "block";

    const menu = $("menu");
    if (menu) menu.style.display = "none";

    // Focus terminal input when opened
    if (id === "terminal") {
        setTimeout(() => $("cmd")?.focus(), 50);
    }
}


// 3. HYDRO START MENU

function toggleMenu() {
    const menu = $("menu");

    if (!menu) return;

    menu.style.display =
        menu.style.display === "block"
            ? "none"
            : "block";
}


// 4. CALENDAR APPLICATION

function drawCalendar() {
    const monthTitle = $("month");
    const grid = $("calgrid");

    if (!monthTitle || !grid) return;

    const now = new Date();
    const year = now.getFullYear();
    const month = now.getMonth();

    monthTitle.textContent = now.toLocaleDateString([], {
        month: "long",
        year: "numeric"
    });

    grid.replaceChildren();

    // Weekday headings
    ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]
        .forEach(day => {
            const cell = document.createElement("div");
            cell.className = "day muted";
            cell.textContent = day;
            grid.appendChild(cell);
        });

    const firstDay = new Date(year, month, 1).getDay();
    const totalDays = new Date(year, month + 1, 0).getDate();

    // Empty spaces before the first day
    for (let i = 0; i < firstDay; i++) {
        grid.appendChild(document.createElement("div"));
    }

    // Calendar dates
    for (let day = 1; day <= totalDays; day++) {
        const cell = document.createElement("div");

        cell.className = "day";
        cell.textContent = day;
        cell.style.cursor = "pointer";

        if (day === now.getDate()) {
            cell.classList.add("today");
        }

        cell.addEventListener("click", () => {
            const selected = $("selectedDate");

            if (selected) {
                selected.textContent =
                    new Date(year, month, day).toLocaleDateString([], {
                        weekday: "long",
                        year: "numeric",
                        month: "long",
                        day: "numeric"
                    });
            }
        });

        grid.appendChild(cell);
    }
}

drawCalendar();


// 5. BASIC HYDRO TERMINAL

const output = $("output");
const commandInput = $("cmd");

function runCommand(command) {
    const parts = command.trim().split(/\s+/);
    const name = (parts[0] || "").toLowerCase();
    const argument = command.trim().slice(name.length).trim();

    switch (name) {
        case "help":
            return [
                "HYDRO OS TERMINAL COMMANDS",
                "help   - Show available commands",
                "date   - Show current date",
                "time   - Show current time",
                "clear  - Clear terminal",
                "about  - About Hydro OS",
                "apps   - List applications",
                "echo   - Print a message"
            ].join("\n");

        case "date":
            return new Date().toDateString();

        case "time":
            return new Date().toLocaleTimeString();

        case "about":
            return "Hydro OS 1.0 — Space Desktop Prototype";

        case "apps":
            return "Clock | Calendar | Terminal | About OS";

        case "echo":
            return argument;

        case "clear":
            if (output) output.textContent = "";
            return null;

        case "":
            return null;

        default:
            return `Command not found: ${name}\nType help to see commands.`;
    }
}

if (commandInput && output) {
    commandInput.addEventListener("keydown", event => {
        if (event.key !== "Enter") return;

        const command = commandInput.value.trim();
        commandInput.value = "";

        if (!command) return;

        const result = runCommand(command);

        if (result !== null) {
            output.textContent +=
                `\n\nhydro@space:~ $ ${command}\n${result}`;
        }

        // Scroll to the latest output
        output.parentElement.scrollTop =
            output.parentElement.scrollHeight;
    });
}


// 6. KEYBOARD SHORTCUTS

document.addEventListener("keydown", event => {
    // Escape closes applications and menu
    if (event.key === "Escape") {
        closeApps();

        const menu = $("menu");
        if (menu) menu.style.display = "none";
    }

    // Ctrl + Alt + T opens Terminal
    if (
        event.ctrlKey &&
        event.altKey &&
        event.key.toLowerCase() === "t"
    ) {
        event.preventDefault();
        openApp("terminal");
    }
});


// 7. HYDRO OS INITIALIZATION

console.log("Hydro OS initialized successfully.");
console.log("Welcome to your digital universe!");
