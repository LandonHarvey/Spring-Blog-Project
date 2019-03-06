let firstcharactersTurn = false;
let secondcharactersTurn = false;
let i = 0;

function beginFightSequence(){
    console.log("HELLO FROM ME");
    if (firstcharactersTurn && secondcharactersTurn || adventure.adventurerList.length === 1){
        document.querySelectorAll('.btn').forEach(elem => {
            elem.style.display = 'none';
        });
        orcs.forEach(orc => {
            let random = Math.round(Math.random() * (1) + 1);
            i++;
            if (orcs[i - 1].health < 5 && orcs[i -1].healing !== 0){
                let health = document.getElementsByClassName('orchealth');
                health[i - 1].innerText  = orcs[i - 1].health += 5;
            }else {
                console.log(random);
                switch (random) {
                    case 1:
                        orcArrow(i);
                        break;
                    case 2:
                        orcMelee(i);
                        break;
                }
            }
        });
        i = 0;
        beginFightSequence();
    }

    document.querySelectorAll('.btn').forEach(elem => {
        elem.style.display = 'block';
    });
}

// heals chosen character
function heals(e) {
    let healing = document.getElementsByClassName('charhealing');
    if (healing[e - 1].innerText != 0){
        healing[e - 1].innerText  = adventure.adventurerList[e-1].healing -= 1;
        let health = document.getElementsByClassName('charhealth');
        health[e - 1].innerText  = adventure.adventurerList[e - 1].health += 5;
        if (firstcharactersTurn) {
            secondcharactersTurn = true;
        } else {
            firstcharactersTurn = true;
        }
        beginFightSequence();
    }
}

// shoots chosen orc
function bow(e) {
    let healing = document.getElementsByClassName('chararrows');
    if (arrows[e - 1].innerText != 0){
        arrows[e - 1].innerText  = adventure.adventurerList[e-1].arrows -= 1;
        let health = document.getElementsByClassName('orchealth');
        health[e - 1].innerText  = orcs[e - 1].health -= 8;
        if (firstcharactersTurn) {
            secondcharactersTurn = true;
        } else {
            firstcharactersTurn = true;
        }
        beginFightSequence();
    }
}

// hits chosen orc
function melee(e) {
        let health = document.getElementsByClassName('orchealth');
        health[e - 1].innerText  = orcs[e - 1].health -= 10;
        if (firstcharactersTurn) {
            secondcharactersTurn = true;
        } else {
            firstcharactersTurn = true;
        }
        beginFightSequence();
}

// orcs arrow attack
function orcArrow(i) {
    let random = Math.round(Math.random() * (1) + 1);
    let health = document.getElementsByClassName('charhealth');
    if (adventure.adventurerList.length === 1){
        health[0].innerText = adventure.adventurerList[0].health -= 5;
    }else {
        health[random - 1].innerText = adventure.adventurerList[random - 1].health -= 5;
        console.log("Arrow");
    }
    let arrow = document.getElementsByClassName('orcarrows');
    arrow[i - 1].innerText = orcs[i - 1].arrows -= 1;
    firstcharactersTurn = false;
    secondcharactersTurn = false;
}

//orcs melee attack
function orcMelee(i) {
    let random = Math.round(Math.random() * (1) + 1);
    let health = document.getElementsByClassName('charhealth');
    if (adventure.adventurerList.length === 1){
        health[0].innerText  = adventure.adventurerList[0].health -= 8;
    }else {
        health[random - 1].innerText  = adventure.adventurerList[random - 1].health -= 8;
    }
    console.log("Melee");
    firstcharactersTurn = false;
    secondcharactersTurn = false;
}