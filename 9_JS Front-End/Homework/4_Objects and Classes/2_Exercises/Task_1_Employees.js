function solve(input) {
    class Employee {
        constructor(name) {
            this.name = name;
            this.number = name.length;
        }
    }

    let employees = [];

    for (let line of input) {
        let employee = new Employee(line);
        employees.push(employee);
    }

    for (let employee of employees) {
        console.log(`Name: ${employee.name} -- Personal Number: ${employee.number}`);
    }
}

solve(['Silas Butler','Adnaan Buckley','Juan Peterson','Brendan Villarreal']);
solve(['Samuel Jackson','Will Smith','Bruce Willis','Tom Holland']);