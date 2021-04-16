const mainScreen = document.querySelector(".main-screen");
const pokeName = document.querySelector(".poke-name");
const pokeId = document.querySelector(".poke-id");
const pokeFrontImage = document.querySelector(".poke-front-image");
const pokeBackImage = document.querySelector(".poke-back-image");
const pokeTypeOne = document.querySelector(".poke-type-one");
const pokeTypeTwo = document.querySelector(".poke-type-two");
const pokeWeight = document.querySelector(".poke-weight");
const pokeHeight = document.querySelector(".poke-height");
const pokeListItems = document.querySelector(".list-item");
const leftButton = document.querySelector(".left-button");
const rightButton = document.querySelector(".right-button");

let prevUrl = null;
let nextUrl = null;
const TYPES = [
    'normal', 'fighting', 'flying',
    'poison', 'ground', 'rock',
    'bug', 'ghost', 'steel',
    'fire', 'water', 'grass',
    'electric', 'psychic', 'ice',
    'dragon', 'dark', 'fairy'
];


const resetScreen = () => {
    for (const type of TYPES) {
        mainScreen.classList.remove(type);
    }
}

fetch('https://pokeapi.co/api/v2/pokemon/4')
    .then(res => res.json())
    .then(data => {
        console.log(data);

        const dataTypes = data['types'];
        const dataFirstType = dataTypes[0];
        const dataSecondType = dataTypes[1];

        pokeTypeOne.textContent = dataFirstType['type']['name'];
        if (dataSecondType) {
            pokeTypeTwo.classList.remove('hide');
            pokeTypeTwo.textContent = dataSecondType['type']['name'];
        } else {
            pokeTypeTwo.classList.add('hide');
            pokeTypeTwo.textContent = '';
        }
        
        mainScreen.classList.add(dataFirstType['type']['name']);
        mainScreen.classList.remove('hide');
        
        pokeName.textContent = data['name'];
        pokeId.textContent = data['id'];
        pokeWeight.textContent = data['weight'];
        pokeHeight.textContent = data['height'];

        pokeFrontImage.src = data['sprites']['front_default'] || '';
        pokeBackImage.src = data['sprites']['back_default'] || '';

    })