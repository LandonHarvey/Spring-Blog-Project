

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
    let bowhtml ='';
    let healhtml = '';
    let formhtml = '';
    let adventureLocation = document.getElementById('characters');
    let formpost = document.getElementById('formpost');
    let orcLocation = document.getElementById('orcs');
    let melee = document.getElementById('melee');
    let bow = document.getElementById('bow');
    let heal = document.getElementById('heal');

    adventure.adventurerList.forEach(char => {
        e++;
        html += '<div>';
        html += `<img src="${char.imgURL}" style="width:50%; max-width: 50%; height: 150px" alt="Character Avatar"/>`;
        html += '<div class="floats">';
        html += `<p>Name: <span class="charname">${char.name}</span></p>
                 <p>Level: <span class="charlevel">${char.level}</span></p>
                 <p>Health: <span class="charhealth">${char.health}</span></p>
                 <p>Healing: <span class="charhealing">${char.healing}</span></p>
                 <p>Arrows: <span class="chararrows">${char.arrows}</span></p>
                 <input type="hidden" value="${char.id}"/>`;
        html += '</div>'
        html += '</div>';
        healhtml += `<button onclick="heals(${e})" class="dropdown-item" type="button" value="${e}">Adventurer: ${char.name}</button>`;
    });

    orcs.forEach(orc => {
        i++;
        html2 += '<div class="orcblock">';
        html2 += `<img src="${orc.imgURL}" style="width:50%; max-width: 50%; height: 150px" alt="Character Avatar"/>`;
        html2 += '<div class="floats2">';
        html2 += `
                 <p>Health: <span class="orchealth">${(Math.round(orc.health - (orcs.length * 1.1)))}</span></p>
                 <p>Healing: <span class="orchealing">${orc.healing}</span></p>
                 <p>Arrows: <span class="orcarrows">${orc.arrows}</span></p>
                 <input type="hidden" value="${orc.id}"/>`;
        html2 += '</div>';
        html2 += '</div>';
        meleehtml += `<button onclick="melee(${i})" class="dropdown-item" type="button" value="${i}">Orc: ${i}</button>`;
        bowhtml += `<button onclick="bow(${i})" class="dropdown-item" type="button" value="${i}">Orc: ${i}</button>`;
    });
    formhtml += '<button class="hiddenForm" onclick="post(adventure)">sadfsdf</button>';
        adventureLocation.innerHTML = html;
        orcLocation.innerHTML = html2;
        melee.innerHTML = meleehtml;
        bow.innerHTML = bowhtml;
        heal.innerHTML = healhtml;
        formpost.innerHTML = formhtml;
        beginFightSequence();
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
            // console.log(orcs);
            // console.log(adventure);
            loadFight(adventure, orcs);
        })})
    })
    .catch(err => console.log(err));
