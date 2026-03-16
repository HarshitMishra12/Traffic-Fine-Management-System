async function loadDashboard(){

const challans = await fetch("/challans").then(r=>r.json());
const vehicles = await fetch("/vehicles").then(r=>r.json());

/* VEHICLE COUNT */

document.getElementById("vehicleCount").innerText = vehicles.length;

/* CHALLAN COUNT */

document.getElementById("challanCount").innerText = challans.length;

/* TOTAL FINE */

let totalFine = 0;

challans.forEach(c => {

totalFine += c.fineAmount;

});

document.getElementById("fineTotal").innerText = "₹" + totalFine;

/* RECENT TABLE */

let table = document.getElementById("recentTable");

table.innerHTML = "";

challans.slice(-5).reverse().forEach(c => {

table.innerHTML += `
<tr>
<td>${c.id}</td>
<td>${c.vehicleNumber}</td>
<td>${c.offenseType}</td>
<td>₹${c.fineAmount}</td>
<td>${c.status}</td>
</tr>
`;

});

}

/* LOAD FIRST TIME */

loadDashboard();

/* REALTIME UPDATE EVERY 5 SECONDS */

setInterval(loadDashboard,5000);