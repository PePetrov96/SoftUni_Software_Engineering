function solve(shift) {
    // 1 bitcoin = 11949.16 lv.
    // 1g of gold = 67.51 lv.
    let money = 0;
    let bitcoins = 0;
    let firstDay = 0;

    for (let i = 0; i < shift.length; i++) {
        let currentMoney = shift[i] * 67.51;
        if ((i+1) % 3 === 0) {
            currentMoney *= 0.7;
        }

        money += currentMoney;

        if (money >= 11949.16 && firstDay === 0) {
            firstDay = i+1;
        }

        while (money >= 11949.16) {
            money -= 11949.16;
            bitcoins++;


        }
    }

    console.log(`Bought bitcoins: ${bitcoins}`);
    if (firstDay !== 0) {
        console.log(`Day of the first purchased bitcoin: ${firstDay}`);
    }
    console.log(`Left money: ${money.toFixed(2)} lv.`);

}

solve([100, 200, 300]);
solve([50, 100]);
solve([3124.15, 504.212, 2511.124]);