

//Get information about every Character on the Screen in order to track health and damage
const id = document.getElementById('idcheck').value;
console.log(id);
const url = '/'+ id + '/fight.json';
const options = {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
    },
};

function loadFight(a, o){
    let adventure = a;
    let orcs = o;
    let i = 0;
    let e = 0;
    let html = '';
    let html2 = '';
    let meleehtml ='';
    let healhtml = '';
    let adventureLocation = document.getElementById('characters');
    let orcLocation = document.getElementById('orcs');
    let melee = document.getElementById('melee');
    let bow = document.getElementById('bow');
    let heal = document.getElementById('heal');

    adventure.adventurerList.forEach(char => {
        e++;
        html += '<div>';
        html += `<img src="${char.imgURL}" style="width:50%; max-width: 50%; height: 150px" alt="Character Avatar"/>`;
        html += '<div class="floats">';
        html += `<p>Name: <span>${char.name}</span></p>
                 <p>Level: <span>${char.level}</span></p>
                 <p>Health: <span>${char.health}</span></p>
                 <p>Healing: <span>${char.healing}</span></p>
                 <p>Arrows: <span>${char.arrows}</span></p>
                 <input type="hidden" value="${char.id}"/>`;
        html += '</div>'
        html += '</div>';
        healhtml += `<button class="dropdown-item" type="button" value="${e}">Adventurer: ${char.name}</button>`;
    });

    orcs.forEach(orc => {
        i++;
        html2 += '<div>';
        html2 += `<img src="${orc.imgURL}" style="width:50%; max-width: 50%; height: 150px" alt="Character Avatar"/>`;
        html2 += '<div class="floats2">';
        html2 += `
                 <p>Health: <span>${(Math.round(orc.health - (orcs.length * 1.1)))}</span></p>
                 <p>Healing: <span>${orc.healing}</span></p>
                 <p>Arrows: <span>${orc.arrows}</span></p>
                 <input type="hidden" value="${orc.id}"/>`;
        html2 += '</div>';
        html2 += '</div>';
        meleehtml += `<button class="dropdown-item" type="button" value="${i}">Orc: ${i}</button>`;
    });
        adventureLocation.innerHTML = html;
        orcLocation.innerHTML = html2;
        melee.innerHTML = meleehtml;
        bow.innerHTML = meleehtml;
        heal.innerHTML = healhtml;
        beginFightSequence();
}

function beginFightSequence(){
    // document.getElementsByClassName('btn').style.display = 'none';
    document.querySelectorAll('.btn').forEach(elem => {
        elem.style.display = 'display';
    });
    // addEventListener("click", )
}

fetch(url, options)
    .then(resa => resa.json()/* post was created successfully */)
    .then(dataa => {
        fetch('/orc.json', options).then(orcresponse => {
            orcresponse.json()
        .then(datao => {
            console.log(datao);
            orcs = datao;
            adventure = dataa;
            console.log(orcs);
            console.log(adventure);
            loadFight(adventure, orcs);
        })})
    })
    .catch(err => console.log(err));


