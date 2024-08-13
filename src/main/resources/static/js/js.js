function selectSeat(seatno) {
    document.querySelector('input[name="seatno"]').value = seatno;
}

// Check if there's an error message and show it as an alert
document.addEventListener("DOMContentLoaded", function() {
    const errorMessage = document.getElementById("error-message").textContent;
    if (errorMessage) {
        alert(errorMessage);
    }
});
