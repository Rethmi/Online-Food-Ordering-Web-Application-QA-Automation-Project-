// Theme management
const themeToggle = document.getElementById('theme-toggle');
const currentTheme = localStorage.getItem('theme') || 'light';

if (currentTheme === 'dark') {
    document.documentElement.setAttribute('data-theme', 'dark');
}

if (themeToggle) {
    themeToggle.addEventListener('click', () => {
        let theme = document.documentElement.getAttribute('data-theme');
        if (theme === 'dark') {
            document.documentElement.setAttribute('data-theme', 'light');
            localStorage.setItem('theme', 'light');
        } else {
            document.documentElement.setAttribute('data-theme', 'dark');
            localStorage.setItem('theme', 'dark');
        }
    });
}

// User Authentication State
const userSession = JSON.parse(localStorage.getItem('currentUser')) || null;
const logoutBtn = document.getElementById('logout-btn');

function updateNav() {
    const navRight = document.getElementById('nav-right');
    if (!navRight) return;

    if (userSession) {
        navRight.innerHTML = `
            <span class="user-info">Hi, ${userSession.name}</span>
            <a href="menu.html">Menu</a>
            <a href="cart.html" id="cart-link">Cart (0)</a>
            <button id="logout-btn" class="btn btn-outline" style="padding: 0.5rem 1rem;">Logout</button>
        `;
        document.getElementById('logout-btn').addEventListener('click', logout);
        updateCartCount();
    } else {
        navRight.innerHTML = `
            <a href="login.html">Login</a>
            <a href="register.html" class="btn btn-primary">Register</a>
        `;
    }
}

function logout() {
    localStorage.removeItem('currentUser');
    window.location.href = 'login.html';
}

// Cart Logic
let cart = JSON.parse(localStorage.getItem('cart')) || [];

function addToCart(product) {
    cart.push(product);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartCount();
    alert(`${product.name} added to cart!`);
}

function removeFromCart(index) {
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    if (typeof loadCartItems === 'function') loadCartItems();
    updateCartCount();
}

function updateCartCount() {
    const cartLink = document.getElementById('cart-link');
    if (cartLink) {
        cartLink.innerText = `Cart (${cart.length})`;
    }
}

// Initialize Nav
document.addEventListener('DOMContentLoaded', () => {
    updateNav();
});
