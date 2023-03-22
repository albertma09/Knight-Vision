/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function toggleMenu() {
    var menu = document.querySelector('.abierto');
    if (menu.style.left === '0%') {
        menu.style.left = '-30%';
        document.body.style.backgroundColor = "white";
    } else {
        menu.style.left = '0%';
       document.body.style.backgroundColor = "#AAAAAA";
    }
}


