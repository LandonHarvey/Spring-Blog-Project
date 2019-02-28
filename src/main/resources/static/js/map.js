
var lastClicked;
let starter = document.getElementById("position").value;
let userId = document.getElementById("id").value;
let oldOrc1 = document.getElementsByClassName("orc1");
let oldOrc2 = document.getElementsByClassName("orc2");
let oldOrc3 = document.getElementsByClassName("orc3");
let oldOrc4 = document.getElementsByClassName("orc4");

//creates clickable grid as well as cout clicked element, row and column
var grid = clickableGrid(18,18,function(el,row,col,i){
    console.log("You clicked on element:",el);
    console.log("You clicked on row:",row);
    console.log("You clicked on col:",col);
    console.log("You clicked on item #:",i);

    // orc class names
    let orcImage = ["orc1", "orc2", "orc3", "orc4"];

    //trying to remove orc classes
    for (let p = 0; p < oldOrc1.length -1; p++) {
        oldOrc1[p].className = "";
        console.log("done" + oldOrc1[p]);
    }
    for (let p = 0; p < oldOrc2.length -1; p++) {
        oldOrc2[p].className = "";
        console.log("done" + oldOrc2[p]);
    }
    for (let p = 0; p < oldOrc3.length -1; p++) {
        oldOrc3[p].className = "";
        console.log("done" + oldOrc3[p]);
    }
    for (let p = 0; p < oldOrc4.length -1; p++) {
        oldOrc4[p].className = "";
        console.log("done" + oldOrc4[p]);
    }

    // random number of orcs on map
    let orcs = Math.round(Math.random() * (100 - 10) + 10);
    let orcsLocation = [];

    //places orcs on map based on location
    for (let p = 0; p < orcs; p++) {
        let num = Math.round(Math.random() * (3 - 0) + 0);
        orcsLocation.push(Math.round(Math.random() * (324 - 1) + 1))

        // places images on orcs based on random number
        orcSlot = Array.from(document.querySelectorAll('td'))
            .find(el => el.textContent === orcsLocation[p] + "");
        orcSlot.setAttribute("class", orcImage[num]);

        console.log(orcsLocation[p] + " " + i);
        if (orcsLocation[p] === i) {
            document.getElementsByClassName("hiddenForm")[1].click();
            return false;
        }
    }

    el.className='clicked';
    if (lastClicked) lastClicked.className='';
    lastClicked = el;
    position.value = i;
    position1.value = i;
    potential.className = "";

});

// where grid is placed
let gridz = document.getElementById('grids');
gridz.appendChild(grid);

//starts grid
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

// potential is the user if an adventure has not been created
let potential = Array.from(document.querySelectorAll('td'))
    .find(el => el.textContent === starter);
    potential.className = "clicked";

let orcSlot;
let orcs = Math.round(Math.random() * (100 - 10) + 10);
let orcsLocation = [];
let orcImage = ["orc", "orc2", "orc3", "orc4"];
for (let p = 0; p < orcs; p++) {
    orcsLocation.push(Math.round(Math.random() * (324 - 1) + 1))
    let num = Math.round(Math.random() * (3 - 0) + 0);
    console.log(orcImage[num] + num);
    orcSlot = Array.from(document.querySelectorAll('td'))
        .find(el => el.textContent === orcsLocation[p] + "");
    orcSlot.setAttribute("class", orcImage[num])
}