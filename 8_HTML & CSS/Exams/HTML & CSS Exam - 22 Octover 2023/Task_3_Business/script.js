window.onscroll = function() {
    var header = document.getElementById('header-container');
    if (window.scrollY > 630) {
        header.classList.add('updated-class');
    } else {
        header.classList.remove('updated-class');
    }
}