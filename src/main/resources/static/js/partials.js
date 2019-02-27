// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
    document.getElementById("img01").src = element.src;
    document.getElementById("modal01").style.display = "block";
    var captionText = document.getElementById("caption");
    captionText.innerHTML = element.alt;
}

let starter = document.getElementById("position").value;
var lastClicked;
var grid = clickableGrid(18,18,function(el,row,col,i){
    console.log("You clicked on element:",el);
    console.log("You clicked on row:",row);
    console.log("You clicked on col:",col);
    console.log("You clicked on item #:",i);

    let oldOrcs = document.getElementsByClassName("orc");
    for (let p = 0; p < oldOrcs.length; p++) {
        oldOrcs[p].className = "";
    }

    let orcs = Math.round(Math.random() * (10 - 1) + 1);
    let orcsLocation = [];

    for (let p = 0; p < orcs; p++) {
        orcsLocation.push(Math.round(Math.random() * (324 - 1) + 1))
        console.log(orcsLocation[p]);

        orcSlot = Array.from(document.querySelectorAll('td'))
            .find(el => el.textContent === orcsLocation[p] + "");
        orcSlot.setAttribute("class", "orc")
    }

    el.className='clicked';
    if (lastClicked) lastClicked.className='';
    lastClicked = el;
    position.value = i;
    potential.className = "";

});

let gridz = document.getElementById('grids');
gridz.appendChild(grid);

function clickableGrid( rows, cols, callback ){
    var i=0;
    var grid = document.createElement('table');
    grid.className = 'grid';
    for (var r=0;r<rows;++r){
        var tr = grid.appendChild(document.createElement('tr'));
        for (var c=0;c<cols;++c){
            var cell = tr.appendChild(document.createElement('td'));
            cell.innerHTML = ++i;
            cell.addEventListener('click',(function(el,r,c,i){
                return function(){
                    callback(el,r,c,i);
                }
            })(cell,r,c,i),false);
        }
    }
    return grid;
}

let potential = Array.from(document.querySelectorAll('td'))
    .find(el => el.textContent === starter);
if (starter === "95") {
    potential.className = "clicked";
}

let orcSlot;
let orcs = Math.round(Math.random() * (10 - 1) + 1);
let orcsLocation = [];

for (let p = 0; p < orcs; p++) {
    orcsLocation.push(Math.round(Math.random() * (324 - 1) + 1))
    console.log(orcsLocation[p]);

    orcSlot = Array.from(document.querySelectorAll('td'))
        .find(el => el.textContent === orcsLocation[p] + "");
    orcSlot.setAttribute("class", "orc")
}