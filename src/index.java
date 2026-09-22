<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Smart Product Search Engine</title>

    <style>

        * {
box-sizing: border-box;
        }

body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f4f6f8;
    color: #222;
}

/* HEADER */

header {
    background: #202124;
    color: white;
    padding: 28px 20px;
    text-align: center;
}

header h1 {
margin: 0;
font-size: 32px;
        }

header p {
margin: 8px 0 0;
color: #d7d7d7;
        }


                /* SEARCH AREA */

                .search-section {
    background: white;
    padding: 25px;
    box-shadow: 0 2px 8px #ddd;
}

        .search-container {
    width: 90%;
    max-width: 1100px;
    margin: auto;
    position: relative;
}

        .search-row {
    display: flex;
    gap: 10px;
}

        #searchBox {
    flex: 1;
    padding: 15px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 7px;
    outline: none;
}

        #searchBox:focus {
    border-color: #333;
}

        .search-button {
    padding: 15px 25px;
    background: #202124;
    color: white;
    border: none;
    border-radius: 7px;
    cursor: pointer;
    font-size: 15px;
}

        .search-button:hover {
    background: #444;
}


/* AUTOCOMPLETE */

        .suggestions {
    position: absolute;
    top: 54px;
    left: 0;
    right: 100px;
    background: white;
    border: 1px solid #ddd;
    border-radius: 6px;
    box-shadow: 0 4px 10px #ddd;
    z-index: 10;
    display: none;
}

        .suggestion {
    padding: 12px 15px;
    cursor: pointer;
}

        .suggestion:hover {
    background: #f1f1f1;
}


/* FILTERS */

        .filters {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    margin-top: 20px;
}

select,
        .price-input {
    padding: 11px;
    border: 1px solid #ccc;
    border-radius: 6px;
    background: white;
}


/* MAIN */

        .main {
    width: 90%;
    max-width: 1200px;
    margin: 30px auto;
}

        .top-bar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

        .top-bar h2 {
margin: 0;
        }

        .result-count {
    color: #666;
}


/* PRODUCTS */

        .products {
    display: grid;
    grid-template-columns:
    repeat(auto-fit, minmax(250px, 1fr));

    gap: 20px;
}

        .product-card {
    background: white;
    border-radius: 12px;
    padding: 20px;
    box-shadow: 0 3px 12px #ddd;
    transition: 0.2s;
}

        .product-card:hover {
    transform: translateY(-4px);
    box-shadow: 0 6px 18px #ccc;
}

        .product-icon {
    height: 130px;
    background: #f0f1f3;
    border-radius: 8px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 55px;
    margin-bottom: 15px;
}

        .product-card h3 {
margin: 8px 0;
font-size: 18px;
        }

                .description {
    color: #666;
    min-height: 40px;
    font-size: 14px;
}

        .brand {
    font-size: 14px;
    margin-top: 12px;
}

        .category {
    font-size: 14px;
    color: #666;
}

        .price {
    font-size: 22px;
    font-weight: bold;
    margin: 12px 0;
}

        .rating {
    font-size: 15px;
}

        .stock {
    margin-top: 10px;
    color: #16803c;
    font-size: 14px;
}

        .out-stock {
    color: #c62828;
}


/* BUTTON */

        .details-button {
    width: 100%;
    margin-top: 15px;
    padding: 11px;
    background: #202124;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
}

        .details-button:hover {
    background: #444;
}


/* NO RESULTS */

        .no-results {
    grid-column: 1 / -1;
    text-align: center;
    background: white;
    padding: 60px;
    border-radius: 10px;
    color: #666;
}


/* FOOTER */

footer {
    background: #202124;
    color: white;
    text-align: center;
    padding: 20px;
    margin-top: 50px;
}


/* MOBILE */

@media(max-width: 700px) {

        .search-row {
    flex-direction: column;
}

            .search-button {
    width: 100%;
}

            .suggestions {
    right: 0;
    top: 110px;
}

            .top-bar {
    flex-direction: column;
    align-items: flex-start;
    gap: 8px;
}
        }

    </style>

</head>


<body>


<!-- HEADER -->

<header>

    <h1>🛒 Smart Product Search</h1>

    <p>
High-Performance E-Commerce Search Engine
        </p>

    <p>
DSA Capstone Project
        </p>

</header>



<!-- SEARCH -->

<section class="search-section">

    <div class="search-container">

        <div class="search-row">

            <input
type="text"
id="searchBox"
placeholder="Search products..."
autocomplete="off"
        >

            <button
class="search-button"
onclick="searchProducts()">

        🔍 Search

        </button>

        </div>


        <!-- AUTOCOMPLETE -->

        <div
id="suggestions"
class="suggestions">
        </div>


        <!-- FILTERS -->

        <div class="filters">

            <select id="brand">

                <option value="all">
All Brands
                </option>

                <option value="Samsung">
Samsung
        </option>

                <option value="Apple">
Apple
        </option>

                <option value="Sony">
Sony
        </option>

                <option value="Nike">
Nike
        </option>

                <option value="Dell">
Dell
        </option>

                <option value="HP">
HP
        </option>

                <option value="Lenovo">
Lenovo
        </option>

                <option value="JBL">
JBL
        </option>

                <option value="Canon">
Canon
        </option>

                <option value="Adidas">
Adidas
        </option>

            </select>


            <select id="category">

                <option value="all">
All Categories
                </option>

                <option value="Electronics">
Electronics
        </option>

                <option value="Laptops">
Laptops
        </option>

                <option value="Audio">
Audio
        </option>

                <option value="Footwear">
Footwear
        </option>

                <option value="Cameras">
Cameras
        </option>

                <option value="Accessories">
Accessories
        </option>

            </select>


            <input
type="number"
id="minPrice"
class="price-input"
placeholder="Min Price"
        >


            <input
type="number"
id="maxPrice"
class="price-input"
placeholder="Max Price"
        >


            <select id="rating">

                <option value="0">
Any Rating
                </option>

                <option value="4">
        ⭐ 4+
                </option>

                <option value="4.5">
        ⭐ 4.5+
                </option>

            </select>


            <select id="sort">

                <option value="default">
Sort
        </option>

                <option value="low">
Price: Low to High
        </option>

                <option value="high">
Price: High to Low
        </option>

                <option value="rating">
Highest Rating
                </option>

            </select>

        </div>

    </div>

</section>



<!-- PRODUCTS -->

<main class="main">

    <div class="top-bar">

        <h2>Products</h2>

        <span
id="resultCount"
class="result-count">
        </span>

    </div>


    <div
id="products"
class="products">
    </div>

</main>



<!-- FOOTER -->

<footer>

    <p>
DSA Capstone Project — Product Search Engine
        </p>

    <p>
Compressed Trie • Price Index • Top-K Retrieval
    </p>

</footer>



<script>


    /* ==========================================
       PRODUCT DATA
       ========================================== */

    const products = [

        {
id: 1,
name: "Samsung Galaxy A55",
brand: "Samsung",
category: "Electronics",
price: 32999,
rating: 4.4,
stock: 12,
icon: "📱",
description: "5G smartphone with AMOLED display"
        },

        {
id: 2,
name: "Samsung Galaxy S25",
brand: "Samsung",
category: "Electronics",
price: 74999,
rating: 4.7,
stock: 8,
icon: "📱",
description: "Premium Samsung smartphone"
        },

        {
id: 3,
name: "Apple iPhone 16",
brand: "Apple",
category: "Electronics",
price: 79999,
rating: 4.8,
stock: 10,
icon: "📱",
description: "Advanced Apple smartphone"
        },

        {
id: 4,
name: "Apple AirPods Pro",
brand: "Apple",
category: "Audio",
price: 24999,
rating: 4.6,
stock: 14,
icon: "🎧",
description: "Wireless earbuds with noise cancellation"
        },

        {
id: 5,
name: "Sony Wireless Headphones",
brand: "Sony",
category: "Audio",
price: 7999,
rating: 4.5,
stock: 20,
icon: "🎧",
description: "Wireless noise cancelling headphones"
        },

        {
id: 6,
name: "Sony Bluetooth Speaker",
brand: "Sony",
category: "Audio",
price: 5999,
rating: 4.3,
stock: 18,
icon: "🔊",
description: "Portable Bluetooth speaker"
        },

        {
id: 7,
name: "Nike Running Shoes",
brand: "Nike",
category: "Footwear",
price: 4999,
rating: 4.3,
stock: 15,
icon: "👟",
description: "Comfortable running shoes"
        },

        {
id: 8,
name: "Adidas Sports Shoes",
brand: "Adidas",
category: "Footwear",
price: 4499,
rating: 4.2,
stock: 17,
icon: "👟",
description: "Lightweight sports shoes"
        },

        {
id: 9,
name: "Dell Inspiron Laptop",
brand: "Dell",
category: "Laptops",
price: 58999,
rating: 4.4,
stock: 7,
icon: "💻",
description: "Everyday performance laptop"
        },

        {
id: 10,
name: "Dell XPS 13",
brand: "Dell",
category: "Laptops",
price: 109999,
rating: 4.7,
stock: 5,
icon: "💻",
description: "Premium compact laptop"
        },

        {
id: 11,
name: "HP Pavilion Laptop",
brand: "HP",
category: "Laptops",
price: 62999,
rating: 4.3,
stock: 9,
icon: "💻",
description: "Reliable laptop for students"
        },

        {
id: 12,
name: "HP Victus Gaming Laptop",
brand: "HP",
category: "Laptops",
price: 79999,
rating: 4.5,
stock: 6,
icon: "💻",
description: "Gaming laptop with powerful performance"
        },

        {
id: 13,
name: "Lenovo IdeaPad Slim",
brand: "Lenovo",
category: "Laptops",
price: 54999,
rating: 4.4,
stock: 11,
icon: "💻",
description: "Slim laptop for everyday work"
        },

        {
id: 14,
name: "Lenovo Legion Gaming",
brand: "Lenovo",
category: "Laptops",
price: 99999,
rating: 4.7,
stock: 4,
icon: "💻",
description: "High-performance gaming laptop"
        },

        {
id: 15,
name: "JBL Flip Speaker",
brand: "JBL",
category: "Audio",
price: 6999,
rating: 4.5,
stock: 21,
icon: "🔊",
description: "Portable waterproof speaker"
        },

        {
id: 16,
name: "JBL Wireless Earbuds",
brand: "JBL",
category: "Audio",
price: 3999,
rating: 4.2,
stock: 25,
icon: "🎧",
description: "Compact wireless earbuds"
        },

        {
id: 17,
name: "Canon EOS Camera",
brand: "Canon",
category: "Cameras",
price: 64999,
rating: 4.6,
stock: 5,
icon: "📷",
description: "Digital camera for photography"
        },

        {
id: 18,
name: "Canon Mirrorless Camera",
brand: "Canon",
category: "Cameras",
price: 89999,
rating: 4.7,
stock: 3,
icon: "📷",
description: "Mirrorless camera with advanced features"
        },

        {
id: 19,
name: "Samsung Smart Watch",
brand: "Samsung",
category: "Accessories",
price: 19999,
rating: 4.4,
stock: 13,
icon: "⌚",
description: "Smart watch with fitness tracking"
        },

        {
id: 20,
name: "Apple Watch Series",
brand: "Apple",
category: "Accessories",
price: 42999,
rating: 4.7,
stock: 8,
icon: "⌚",
description: "Smart watch with health features"
        },

        {
id: 21,
name: "Sony Smart TV",
brand: "Sony",
category: "Electronics",
price: 55999,
rating: 4.5,
stock: 6,
icon: "📺",
description: "4K smart television"
        },

        {
id: 22,
name: "Samsung 4K Smart TV",
brand: "Samsung",
category: "Electronics",
price: 61999,
rating: 4.6,
stock: 7,
icon: "📺",
description: "4K smart TV with modern display"
        },

        {
id: 23,
name: "Nike Sports T-Shirt",
brand: "Nike",
category: "Footwear",
price: 1999,
rating: 4.1,
stock: 30,
icon: "👕",
description: "Lightweight sports t-shirt"
        },

        {
id: 24,
name: "Adidas Running Shoes",
brand: "Adidas",
category: "Footwear",
price: 5999,
rating: 4.5,
stock: 16,
icon: "👟",
description: "Running shoes for daily training"
        },

        {
id: 25,
name: "Apple MacBook Air",
brand: "Apple",
category: "Laptops",
price: 99999,
rating: 4.8,
stock: 6,
icon: "💻",
description: "Thin and powerful laptop"
        },

        {
id: 26,
name: "Samsung Galaxy Tablet",
brand: "Samsung",
category: "Electronics",
price: 28999,
rating: 4.4,
stock: 10,
icon: "📱",
description: "Large display Android tablet"
        },

        {
id: 27,
name: "Sony Digital Camera",
brand: "Sony",
category: "Cameras",
price: 72999,
rating: 4.7,
stock: 4,
icon: "📷",
description: "High-quality digital camera"
        },

        {
id: 28,
name: "Dell Wireless Mouse",
brand: "Dell",
category: "Accessories",
price: 1499,
rating: 4.1,
stock: 35,
icon: "🖱️",
description: "Comfortable wireless mouse"
        },

        {
id: 29,
name: "HP Wireless Keyboard",
brand: "HP",
category: "Accessories",
price: 1999,
rating: 4.2,
stock: 28,
icon: "⌨️",
description: "Wireless keyboard for desktop use"
        },

        {
id: 30,
name: "Lenovo Wireless Mouse",
brand: "Lenovo",
category: "Accessories",
price: 1299,
rating: 4.1,
stock: 32,
icon: "🖱️",
description: "Simple wireless mouse"
        }

        ];


    /* ==========================================
       DISPLAY PRODUCTS
       ========================================== */

function displayProducts(list) {

        const container =
            document.getElementById("products");

        const resultCount =
            document.getElementById("resultCount");

    container.innerHTML = "";

    resultCount.textContent =
            list.length + " products found";


    if (list.length === 0) {

        container.innerHTML = `
            <div class="no-results">

                <h2>😕 No Products Found</h2>

                <p>
                Try changing your search or filters.
                </p>

                </div>
        `;

        return;
    }


    list.forEach(function(product) {

            const card =
                document.createElement("div");

        card.className = "product-card";


        let stockText;

        let stockClass = "stock";


        if (product.stock === 0) {

            stockText = "Out of stock";

            stockClass = "stock out-stock";

        } else {

            stockText =
                    "Stock: " + product.stock;

        }


        card.innerHTML = `

            <div class="product-icon">
                ${product.icon}
            </div>

                <h3>
                ${product.name}
            </h3>

                <p class="description">
                ${product.description}
            </p>

                <p class="brand">
                <b>Brand:</b>
                ${product.brand}
            </p>

                <p class="category">
                <b>Category:</b>
                ${product.category}
            </p>

                <p class="price">
                ₹${product.price.toLocaleString("en-IN")}
            </p>

                <p class="rating">
                ⭐ ${product.rating}
            </p>

                <p class="${stockClass}">
                📦 ${stockText}
            </p>

                <button
        class="details-button"
        onclick="showProduct(${product.id})">

                View Details

                </button>

        `;


        container.appendChild(card);

    });

}


    /* ==========================================
       SEARCH
       ========================================== */

function searchProducts() {

        const keyword =
            document
                    .getElementById("searchBox")
                    .value
                    .toLowerCase()
                    .trim();


        const brand =
            document
                    .getElementById("brand")
                    .value;


        const category =
            document
                    .getElementById("category")
                    .value;


        const minPrice =
            Number(
                    document
                            .getElementById("minPrice")
                            .value
            ) || 0;


        const maxPriceValue =
            document
                    .getElementById("maxPrice")
                    .value;


        const maxPrice =
            maxPriceValue === ""
                    ? Infinity
                    : Number(maxPriceValue);


        const minRating =
            Number(
                    document
                            .getElementById("rating")
                            .value
            );


        const sort =
            document
                    .getElementById("sort")
                    .value;


    let result =
            products.filter(function(product) {


                const keywordMatch =
                keyword === ""
                        ||
                        product.name
                                .toLowerCase()
                                .includes(keyword);


                const brandMatch =
                brand === "all"
                        ||
                        product.brand === brand;


                const categoryMatch =
                category === "all"
                        ||
                        product.category === category;


                const priceMatch =
                product.price >= minPrice
                        &&
                        product.price <= maxPrice;


                const ratingMatch =
                product.rating >= minRating;


        return keywordMatch
                &&
                brandMatch
                &&
                categoryMatch
                &&
                priceMatch
                &&
                ratingMatch;

    });


    /* SORT */

    if (sort === "low") {

        result.sort(
                (a, b) => a.price - b.price
            );

    }

    else if (sort === "high") {

        result.sort(
                (a, b) => b.price - a.price
            );

    }

    else if (sort === "rating") {

        result.sort(
                (a, b) => b.rating - a.rating
            );

    }


    displayProducts(result);

}


    /* ==========================================
       AUTOCOMPLETE
       ========================================== */

    const searchBox =
        document.getElementById("searchBox");

    const suggestions =
        document.getElementById("suggestions");


    searchBox.addEventListener(
        "input",
        function() {

            const text =
            searchBox.value
                    .toLowerCase()
                    .trim();


    suggestions.innerHTML = "";


    if (text === "") {

        suggestions.style.display =
                "none";

        return;

    }


            const matches =
            products
                    .filter(function(product) {

        return product.name
                .toLowerCase()
                .startsWith(text);

    })
                    .slice(0, 6);


    if (matches.length === 0) {

        suggestions.style.display =
                "none";

        return;

    }


    matches.forEach(function(product) {

                const item =
                document.createElement("div");

        item.className =
                "suggestion";


        item.textContent =
                product.name;


        item.onclick = function() {

            searchBox.value =
                    product.name;

            suggestions.style.display =
                    "none";

            searchProducts();

        };


        suggestions.appendChild(item);

    });


    suggestions.style.display =
            "block";

}
    );


    /* ==========================================
       CLOSE AUTOCOMPLETE
       ========================================== */

            document.addEventListener(
        "click",
        function(event) {

    if (
            !event.target.closest(
                    ".search-container"
            )
    ) {

        suggestions.style.display =
                "none";

    }

}
    );


    /* ==========================================
       PRODUCT DETAILS
       ========================================== */

function showProduct(id) {

        const product =
            products.find(
                    p => p.id === id
            );


    if (!product) {
        return;
    }


    alert(
            "Product: " + product.name +
                    "\n\n" +

                    "Brand: " + product.brand +
                    "\n" +

                    "Category: " + product.category +
                    "\n" +

                    "Price: ₹" + product.price +
                    "\n" +

                    "Rating: " + product.rating +
                    "\n" +

                    "Stock: " + product.stock +
                    "\n\n" +

                    product.description
    );

}


    /* ==========================================
       FILTER EVENT LISTENERS
       ========================================== */

    document
            .getElementById("brand")
        .addEventListener(
            "change",
            searchProducts
            );


    document
            .getElementById("category")
        .addEventListener(
            "change",
            searchProducts
            );


    document
            .getElementById("minPrice")
        .addEventListener(
            "input",
            searchProducts
            );


    document
            .getElementById("maxPrice")
        .addEventListener(
            "input",
            searchProducts
            );


    document
            .getElementById("rating")
        .addEventListener(
            "change",
            searchProducts
            );


    document
            .getElementById("sort")
        .addEventListener(
            "change",
            searchProducts
            );


    /* ==========================================
       ENTER KEY SEARCH
       ========================================== */

    searchBox.addEventListener(
        "keydown",
        function(event) {

    if (event.key === "Enter") {

        suggestions.style.display =
                "none";

        searchProducts();

    }

}
    );


    /* ==========================================
       INITIAL DISPLAY
       ========================================== */

displayProducts(products);

</script>


</body>

</html>