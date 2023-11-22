function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      class Worker {
         constructor(name, salary) {
            this.name = name;
            this.salary = salary;
         }
      }
      class Restaurant {
         constructor(name) {
            this.name = name;
            this.workers = [];
            this.averageSalary = 0;
         }
         getAverageSalary() {
            let number = this.workers.length;
            let total = 0;
            this.workers.forEach(worker => total += worker.salary);
            this.averageSalary = (Number(total) / Number(number)).toFixed(2);
         }
         sortWorkers() {
            this.workers = this.workers.sort((a,b) => b.salary - a.salary);
         }

         getBestSalary() {
            let best = -99999999;
            for (const worker of this.workers) {
               if (worker.salary > best) {
                  best = worker.salary;
               }
            }
            return Number(best);
         }
      }
      function fillRestaurants(inputText) {
         let restaurantsMap = new Map();
         let restaurantEntries = JSON.parse(inputText);

         for (const restaurant of restaurantEntries) {
            let tokens = restaurant.split(' - ');
            let restaurantName = tokens.shift();
            let workers = tokens[0].split(', ');

            if (!restaurantsMap.has(restaurantName)) {
               let restaurant = new Restaurant(restaurantName);

               for (const worker of workers) {
                  let tokens = worker.split(' ');
                  let currentWorker = new Worker(tokens[0], Number(tokens[1]));

                  restaurant.workers.push(currentWorker);
               }

               restaurantsMap.set(restaurantName, restaurant);
            } else {
               for (const worker of workers) {
                  let tokens = worker.split(' ');
                  let name = tokens[0];
                  let salary = Number(tokens[1]);

                  if (!restaurantsMap.get(restaurantName).workers.some(w => w.name === name)) {
                     let currentWorker = new Worker(name, salary);
                     restaurantsMap.get(restaurantName).workers.push(currentWorker);
                  }
               }
            }
         }

         return restaurantsMap;
      }

      function getBestRestaurant(restaurants) {
         restaurants.forEach(value => value.getAverageSalary());

         let sortedRestaurants = new Map([...restaurants.entries()].sort((a,b) => {
            let restA = a[1].averageSalary;
            let restB = b[1].averageSalary;
            return restB - restA;
         }));

         return [...sortedRestaurants.values()][0];
      }

      function getRestaurantOutput(restaurant) {
         let name = restaurant.name;
         let average = Number(restaurant.averageSalary).toFixed(2);
         let best = Number(restaurant.getBestSalary()).toFixed(2);

         return `Name: ${name} Average Salary: ${average} Best Salary: ${best}`;
      }

      function getWorkerOutput(restaurant) {
         restaurant.sortWorkers();
         let result = "";
         let workers = restaurant.workers;

         for (const worker of workers) {
            result += (`Name: ${worker.name} With Salary: ${worker.salary} `);
         }

         return result.trim();
      }

      let inputText = document.querySelector("#inputs textarea").value;

      let restaurantsMap = fillRestaurants(inputText);

      let bestRestaurant = getBestRestaurant(restaurantsMap);

      let restaurantOutput = getRestaurantOutput(bestRestaurant);
      let workerOutput = getWorkerOutput(bestRestaurant);

      document.querySelector("#bestRestaurant p").textContent = restaurantOutput;
      document.querySelector("#workers p").textContent = workerOutput;
   }
}