function solve(input) {
    const targetThickness = input[0];

    for (let i = 1; i < input.length; i++) {
        let initialThickness = input[i];
        console.log(`Processing chunk ${initialThickness} microns`);

        let operationsCount = 0;
        let cutCount = 0;
        let lapCount = 0;
        let grindCount = 0;
        let etchCount = 0;
        let xrayUsed = false;

        while (initialThickness > targetThickness) {
            if (initialThickness / 4 >= targetThickness - 1) {
                initialThickness /= 4;
                cutCount++;
            } else if (initialThickness * 0.8 >= targetThickness - 1) {
                initialThickness *= 0.8;
                lapCount++;
            } else if (initialThickness - 20 >= targetThickness - 1) {
                initialThickness -= 20;
                grindCount++;
            } else if (initialThickness - 2 >= targetThickness - 1) {
                initialThickness -= 2;
                etchCount++;
            } else if (!xrayUsed) {
                initialThickness += 1;
                xrayUsed = true;
            }

            operationsCount++;
        }

        if (cutCount > 0) {
            console.log(`Cut x${cutCount}`);
            console.log("Transporting and washing");
        }
        if (lapCount > 0) {
            console.log(`Lap x${lapCount}`);
            console.log("Transporting and washing");
        }
        if (grindCount > 0) {
            console.log(`Grind x${grindCount}`);
            console.log("Transporting and washing");
        }
        if (etchCount > 0) {
            console.log(`Etch x${etchCount}`);
            console.log("Transporting and washing");
        }

        if (xrayUsed) {
            console.log("X-ray x1");
        }

        console.log(`Finished crystal ${targetThickness} microns`);
    }
}


solve([1375, 50000]);
solve([1000, 4000, 8100]);