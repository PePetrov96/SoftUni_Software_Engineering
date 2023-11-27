function solve() {
    const outputTextarea = document.querySelector('textarea');
    const addButtons = document.querySelectorAll('.add-product');
    const checkoutButton = document.querySelector('.checkout');

    let totalCosts = 0;
    let itemsList = [];

    function checkout() {
        outputTextarea.textContent += `You bought ${itemsList.join(', ')} for ${totalCosts.toFixed(2)}.`;

        // Disable all add product button event listeners
        for (const button of addButtons) {
            button.removeEventListener('click', addToCart);
        }

        // Disable checkout button event listener
        checkoutButton.removeEventListener('click', checkout);
    }

    checkoutButton.addEventListener('click', checkout);

    function addToCart() {
        let product = this.parentElement.parentElement;

        let productName = product.querySelector('.product-title').textContent;
        let productPrice = product.querySelector('.product-line-price').textContent;

        totalCosts += Number(productPrice);
        if (!itemsList.includes(productName)) {
            itemsList.push(productName);
        }

        outputTextarea.textContent += `Added ${productName} for ${productPrice} to the cart.\n`;
    }

    for (const button of addButtons) {
        button.addEventListener('click', addToCart);
    }
}

