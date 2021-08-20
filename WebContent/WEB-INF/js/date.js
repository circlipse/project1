/**
 * 
 */
let [today] = new Date().toISOString().split("T");
document.querySelector("input").setAttribute("min", today);