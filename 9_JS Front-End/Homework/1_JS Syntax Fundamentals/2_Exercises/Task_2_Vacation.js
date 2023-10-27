function solve(people, groupType, day) {
    let ticketPrice = 0;

    switch (groupType) {
        case "Students":
            if (day === "Friday") {
                ticketPrice = 8.45;
            } else if (day === "Saturday") {
                ticketPrice = 9.80;
            } else if (day === "Sunday") {
                ticketPrice = 10.46;
            }
            break;
        case "Business":
            if (day === "Friday") {
                ticketPrice = 10.90;
            } else if (day === "Saturday") {
                ticketPrice = 15.60;
            } else if (day === "Sunday") {
                ticketPrice = 16;
            }
            break;
        case "Regular":
            if (day === "Friday") {
                ticketPrice = 15;
            } else if (day === "Saturday") {
                ticketPrice = 20;
            } else if (day === "Sunday") {
                ticketPrice = 22.50;
            }
            break;
    }

    let totalCost = 0;

    if (groupType === "Students" && people >= 30) {
        totalCost = (people * ticketPrice) * 0.85;
    } else if (groupType === "Business" && people >= 100) {
        totalCost = (people - 10) * ticketPrice;
    } else if (groupType === "Regular" && people >= 10 && people <= 20) {
        totalCost = (people * ticketPrice) * 0.95;
    } else {
        totalCost = people * ticketPrice;
    }

    console.log(`Total price: ${totalCost.toFixed(2)}`);
}