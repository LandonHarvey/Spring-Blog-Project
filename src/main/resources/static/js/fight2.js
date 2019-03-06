let firstcharactersTurn = false;
let secondcharactersTurn = false;
let orcblock = document.getElementsByClassName('orcblock');
let i = 0;
let orcsDead = 0;

function beginFightSequence(){
    if (adventure.adventurerList[0].health === 0 && (adventure.adventurerList[1] === 0 || adventure.adventurerList[1] == null))
    {
        window.location.href = `/adventures/${adventure.id}/delete`
    }
    if (firstcharactersTurn && secondcharactersTurn){
        document.querySelectorAll('.btn').forEach(elem => {
            elem.style.display = 'none';
        });
        orcs.forEach(orc => {
            let random = Math.round(Math.random() * (1) + 1);
            i++;
            if (orc.health <= 0) {
                orcsDead++;
                orcblock[i - 1].style.display = 'none';
            }else {
                if (orcs[i - 1].health < 5 && orcs[i - 1].healing !== 0) {
                    let health = document.getElementsByClassName('orchealth');
                    health[i - 1].innerText = orcs[i - 1].health += 5;
                } else {
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
            }
            if (orcsDead === orcs.length){
                document.getElementsByClassName("hiddenForm")[0].click();
                setTimeout(2000);
            }else {
                i = 0;
                beginFightSequence();
            }
        });
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
    let arrows = document.getElementsByClassName('chararrows');
    if (firstcharactersTurn && adventure.adventurerList[1] != null) {
        if (arrows[1].innerText !== '0') {
            arrows[1].innerText = adventure.adventurerList[1].arrows -= 1;
        }
        beginFightSequence();
    } else {
        if (arrows[0].innerText !== '0') {
            arrows[0].innerText = adventure.adventurerList[0].arrows -= 1;
        }
        beginFightSequence();
    }
    let health = document.getElementsByClassName('orchealth');
    health[e - 1].innerText = orcs[e - 1].health -= 8;
    if (firstcharactersTurn) {
        secondcharactersTurn = true;
    } else {
        firstcharactersTurn = true;
    }
    beginFightSequence();
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

function post(adventure) {
    fetch(`/adventures/${adventure.id}/fightwon`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(adventure)
    }).then( response => {
        window.location.href = `/adventures/${adventure.id}`
    });
}


