/**
 * 
 */
let [today2] = new Date().toISOString().split("T");
document.querySelectorAll("input")[3].setAttribute("min", today2);