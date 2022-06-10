// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
    const greetings =
        ['My favorite food is donuts.',
            'I\'ve had surgery 3 times.',
            'My favorite TV show of all time is Prison Break.',
            'I play basketball.'];


    // Pick a random greeting.
    const greeting = greetings[Math.floor(Math.random() * greetings.length)];

    // Add it to the page.
    const greetingContainer = document.getElementById('greeting-container');
    greetingContainer.innerText = greeting;


}
function mod1PopUp() {
    const mod1Container = document.getElementById('mod1-container');

    mod1Container.classList.add('show');


};
function mod1Close(){
    const mod1Container = document.getElementById('mod1-container');
    mod1Container.classList.remove('show');

}
function mod2PopUp() {
    const mod2Container = document.getElementById('mod2-container');

    mod2Container.classList.add('show');


};
function mod2Close(){
    const mod2Container = document.getElementById('mod2-container');
    mod2Container.classList.remove('show');

}
function mod3PopUp() {
    const mod3Container = document.getElementById('mod3-container');

    mod3Container.classList.add('show');


};
function mod3Close(){
    const mod3Container = document.getElementById('mod3-container');
    mod3Container.classList.remove('show');

}
function mod4PopUp() {
    const mod4Container = document.getElementById('mod4-container');

    mod4Container.classList.add('show');


};
function mod4Close(){
    const mod4Container = document.getElementById('mod4-container');
    mod4Container.classList.remove('show');

}


async function showFunFact(){
    const response = await fetch('/hello');
    const facts = await response.json();
    const chosenFact = facts[Math.floor(Math.random()*3)];
    const factpara = document.getElementById('fact')
    factpara.innerText = chosenFact;
}