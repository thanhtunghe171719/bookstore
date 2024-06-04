/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// JavaScript to handle carousel navigation
function showSlide(index) {
    let indicators = document.querySelectorAll('.carousel-indicators li');
    let carousel = document.querySelector('.carousel-inner');
    let items = carousel.querySelectorAll('.carousel-item');
    
    // Remove active class from all indicators and items
    indicators.forEach(indicator => indicator.classList.remove('active'));
    
    // Add active class to the clicked indicator and corresponding item
    indicators[index].classList.add('active');
    
    // Hide all "Read More" in each item
    items.forEach(item => {
        let readMores = item.querySelectorAll('.read_more');
        readMores.forEach(readMore => {
            readMore.style.display = 'none';
        });
    });
    
    // Show "Read More" of the active slide
    let readMoresOfActiveSlide = items[index].querySelectorAll('.read_more');
    readMoresOfActiveSlide.forEach(readMore => {
        readMore.style.display = 'block';
    });

    // Swap the selected item with the middle item
    let middleItem = items[0];
    let selectedItem = items[index];
    
    if (index !== 0) {
        let middleHTML = middleItem.innerHTML;
        middleItem.innerHTML = selectedItem.innerHTML;
        selectedItem.innerHTML = middleHTML;
    }
}


// Function to automatically advance to the next slide
function autoSlide() {
    let indicators = document.querySelectorAll('.carousel-indicators li');
    let activeIndex = Array.from(indicators).findIndex(indicator => indicator.classList.contains('active'));
    let nextIndex = (activeIndex + 1) % indicators.length;
    showSlide(nextIndex);
}

// Set an interval to automatically switch slides every 10 seconds
setInterval(autoSlide, 10000);
