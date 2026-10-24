/* =================================
   HYDRO OS — SPACE DESKTOP THEME
   ================================= */

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    height: 100vh;
    overflow: hidden;
    color: #ffffff;
    font-family: Arial, Helvetica, sans-serif;

    /* Space wallpaper */
    background:
        radial-gradient(
            circle at 75% 65%,
            #244fa0 0%,
            transparent 35%
        ),
        radial-gradient(
            circle at 25% 20%,
            #492478 0%,
            transparent 40%
        ),
        linear-gradient(
            145deg,
            #030611,
            #101b40,
            #030611
        );
}

/* Space stars */

.stars {
    position: fixed;
    inset: 0;
    pointer-events: none;
    background-image:
        radial-gradient(white 1px, transparent 1px);
    background-size: 47px 53px;
    opacity: 0.35;
}

/* Planet */

.planet {
    position: fixed;
    width: 240px;
    height: 240px;
    top: 20%;
    right: 13%;
    border-radius: 50%;

    background: linear-gradient(
        130deg,
        #9bbaff,
        #4933a0 55%,
        #101a48
    );

    box-shadow:
        0 0 70px #526dff77,
        inset -30px -20px 55px #05091d;
}

/* Desktop */

.desktop {
    position: relative;
    height: calc(100vh - 60px);
    padding: 20px;
}

.brand {
    font-size: 30px;
    font-weight: 800;
    letter-spacing: 3px;
}

.sub {
    margin-top: 6px;
    color: #a6b9ef;
    font-size: 12px;
}

/* Desktop application icons */

.icons {
    display: flex;
    flex-direction: column;
    gap: 22px;
    margin-top: 35px;
    width: 85px;
}

.appicon {
    text-align: center;
    font-size: 12px;
    cursor: pointer;
}

.appicon span {
    display: grid;
    place-items: center;
    width: 54px;
    height: 54px;
    margin: 0 auto 7px;

    border: 1px solid #ffffff28;
    border-radius: 16px;
    background: #ffffff13;
    backdrop-filter: blur(12px);

    font-size: 25px;
    transition: 0.2s;
}

.appicon:hover span {
    background: #4d7bff55;
    transform: translateY(-3px);
}

/* Application windows */

.window {
    position: absolute;
    top: 12%;
    left: 23%;

    width: min(540px, 72vw);
    height: min(430px, 65vh);

    display: none;
    overflow: hidden;

    border: 1px solid #ffffff35;
    border-radius: 15px;

    background: #10162bed;
    backdrop-filter: blur(20px);

    box-shadow: 0 25px 90px #0009;
}

.winhead {
    height: 48px;
    padding: 0 15px;

    display: flex;
    align-items: center;
    justify-content: space-between;

    background: #ffffff0b;
    border-bottom: 1px solid #ffffff18;
}

.content {
    height: calc(100% - 48px);
    padding: 18px;
    overflow: auto;
}

/* Close button */

.close {
    width: 13px;
    height: 13px;
    border: none;
    border-radius: 50%;
    background: #e45d70;
    cursor: pointer;
}

/* Hydro taskbar */

#taskbar {
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;

    height: 60px;
    padding: 0 15px;

    display: flex;
    align-items: center;
    gap: 12px;

    background: #080d1cdd;
    border-top: 1px solid #ffffff25;
    backdrop-filter: blur(20px);
}

/* Hydro menu button */

#menuBtn {
    padding: 10px 15px;
    border: none;
    border-radius: 10px;

    background: #3154b9;
    color: white;

    font-weight: bold;
    cursor: pointer;
    transition: 0.2s;
}

#menuBtn:hover {
    background: #527aff;
}

/* Taskbar application buttons */

.taskapp {
    padding: 10px;
    border: none;
    border-radius: 9px;

    background: #ffffff12;
    color: white;
    cursor: pointer;
}

.taskapp:hover {
    background: #ffffff24;
}

/* Clock and date */

#clock {
    margin-left: auto;
    text-align: right;
    font-size: 13px;
    line-height: 1.5;
}

/* Start menu */

#menu {
    position: fixed;
    bottom: 70px;
    left: 12px;

    width: 250px;
    padding: 15px;

    display: none;

    background: #10182cf5;
    border: 1px solid #ffffff2a;
    border-radius: 16px;

    box-shadow: 0 15px 50px #0009;
    backdrop-filter: blur(20px);
}

.menuitem {
    padding: 12px;
    border-radius: 8px;
    cursor: pointer;
}

.menuitem:hover {
    background: #ffffff24;
}

/* Calendar */

.calgrid {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    gap: 5px;
}

.day {
    padding: 9px 2px;
    text-align: center;
    background: #ffffff0b;
    border-radius: 6px;
}

.day.today {
    background: #4269df;
}

.muted {
    color: #aab9d9;
}

/* Terminal */

.terminal {
    color: #8fffc0;
    font-family: monospace;
    font-size: 14px;
}

#cmd {
    width: 80%;
    color: white;
    background: transparent;
    border: none;
    outline: none;
    font-family: monospace;
}

#output {
    white-space: pre-wrap;
    line-height: 1.7;
}

/* Headings */

h2 {
    margin-top: 0;
}

/* Smaller screens */

@media (max-width: 600px) {
    .planet {
        width: 150px;
        height: 150px;
        right: 8%;
        top: 25%;
    }

    .window {
        top: 8%;
        left: 5%;
        width: 90%;
        height: 75vh;
    }

    #taskbar {
        gap: 7px;
        padding: 0 8px;
    }

    .brand {
        font-size: 25px;
    }
}
