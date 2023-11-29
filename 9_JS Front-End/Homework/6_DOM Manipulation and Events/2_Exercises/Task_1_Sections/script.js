function create(words) {
   const contentDiv = document.getElementById('content');

   for (const word of words) {
      // Create a div for each word
      const div = document.createElement('div');
      div.classList.add('section');

      // Create a paragraph for the word
      const paragraph = document.createElement('p');
      paragraph.textContent = word;
      div.appendChild(paragraph);

      // Initially hide the paragraph
      paragraph.style.display = 'none';

      // Add click event to show the hidden paragraph
      div.addEventListener('click', function() {
         if (paragraph.style.display === 'none') {
            paragraph.style.display = 'block';
         } else {
            paragraph.style.display = 'none';
         }
      });

      // Append the div to the content element
      contentDiv.appendChild(div);
   }
}
