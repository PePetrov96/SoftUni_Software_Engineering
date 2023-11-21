function solve(inputArrays) {
    function addArrays() {
        let output = [];

        for (const inputArray of inputArrays) {
            let array = JSON.parse(inputArray);
            array.sort((a, b) => b - a);

            let stringedArray = JSON.stringify(array);

            if (!output.some(array => JSON.stringify(array) === stringedArray)) {
                output.push(array);
            }
        }

        return output;
    }

    let outputArrays = addArrays();

    function sortAndPrint(array) {
        let sortedArray = array.sort((a, b) => a.length - b.length);
        sortedArray.forEach(array => {
            let string = JSON.stringify(array).replace('[','').replace(']', '');
            let output = string.split(',');
            console.log(`[${output.join(', ')}]`);
        });
    }

    sortAndPrint(outputArrays);
}

solve(["[-3, -2, -1, 0, 1, 2, 3, 4]", "[10, 1, -17, 0, 2, 13]", "[4, -3, 3, -2, 2, -1, 1, 0]"]);
solve(["[7.14, 7.180, 7.339, 80.099]", "[7.339, 80.0990, 7.140000, 7.18]", "[7.339, 7.180, 7.14, 80.099]"]);