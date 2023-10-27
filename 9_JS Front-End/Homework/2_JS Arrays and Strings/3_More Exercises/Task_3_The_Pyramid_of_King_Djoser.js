function solve(base, increment) {
    let gold = 0;

    if (base % 2 === 0) {
        gold = 4 * increment;
    } else {
        gold = 1 * increment;
    }

    let pyramidHeight = (Math.ceil(base / 2));
    let stone = 0;
    let marble = 0;
    let lapisLazuli = 0;

    for (let i = 1; i < pyramidHeight; i++) {
        let currentStone = 0;
        let currentMarble = 0;
        let currentLapisLazuli = 0;

        if (i % 5 === 0) {
            currentLapisLazuli = ((base * 4) - 4);
            currentStone = (base * base) - currentLapisLazuli;
        } else {
            currentMarble = ((base * 4) - 4);
            currentStone = (base * base) - currentMarble;
        }

        stone += (currentStone * increment);
        marble += (currentMarble * increment);
        lapisLazuli += (currentLapisLazuli * increment);

        base -= 2;
    }

    console.log(`Stone required: ${Math.ceil(stone)}\nMarble required: ${Math.ceil(marble)}\nLapis Lazuli required: ${Math.ceil(lapisLazuli)}\nGold required: ${Math.ceil(gold)}\nFinal pyramid height: ${Math.floor(pyramidHeight * increment)}`);
}

solve(11,1);
solve(11,0.75);
solve(12,1);