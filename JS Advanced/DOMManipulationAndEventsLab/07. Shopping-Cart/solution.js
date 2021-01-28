function solve() {
    const shoppingCart = document.querySelector('div.shopping-cart');
    shoppingCart.addEventListener('click',onClick);
    let textArea = document.querySelector('div.shopping-cart>textarea');
    const products = [];
    let totalPrice = 0;
    function onClick(ev) {
        if(ev.target.className==='add-product'){
            const product = ev.target.parentNode.parentNode;
            const name = product.querySelector('.product-title').textContent;
            const price = product.querySelector('.product-line-price').textContent;
            textArea.textContent+=`Added ${name} for ${price} to the cart.\n`;
            if(!products.includes(name)){
                products.push(name);
            }
            totalPrice+=Number(price);
        }else if(ev.target.className==='checkout'){
            textArea.textContent+=`You bought ${products.join(', ')} for ${totalPrice.toFixed(2)}.`;
            Array.from(document.querySelectorAll('button')).forEach(b=>b.disabled =true);
        }
    }
}