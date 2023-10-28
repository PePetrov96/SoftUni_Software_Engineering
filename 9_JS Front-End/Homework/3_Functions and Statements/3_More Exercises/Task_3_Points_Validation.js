function solve(points) {
    const [x1, y1, x2, y2] = points;

    function calculateDistance(x1, y1, x2, y2) {
        return Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);
    }

    function isInteger(value) {
        return Number.isInteger(value);
    }

    const distance1ToOrigin = calculateDistance(x1, y1, 0, 0);
    const distance2ToOrigin = calculateDistance(x2, y2, 0, 0);
    const distance1To2 = calculateDistance(x1, y1, x2, y2);

    if (isInteger(distance1ToOrigin)) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }

    if (isInteger(distance2ToOrigin)) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }

    if (isInteger(distance1To2)) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }
}

solve([3, 0, 0, 4]);
solve([2, 1, 1, 1]);