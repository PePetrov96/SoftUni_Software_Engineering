function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);
   function onClick() {
      let tbody = document.querySelector('.container tbody');
      let rows = tbody.getElementsByTagName('tr');

      for (const row of rows) {
         row.classList.remove('select');
      }

      let input = document.getElementById("searchField").value;

      if (input === "") {
         return;
      }

      for (let i = 0; i < rows.length; i++) {
         let fields = rows[i].getElementsByTagName("td");

         for (const field of fields) {
            if (field.textContent.toLowerCase().includes(input.toLowerCase())) {
               rows[i].classList.add('select');
               break;
            }
         }
      }

      document.getElementById("searchField").value = "";
   }
}

