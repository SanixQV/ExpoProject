let name;
let life;
let money;
let awake;

function init (n,l,m){
  this.name = n;
  this.life = l;
  this.money = m;
  this.awake = true;
}
function showme(){
  let etat = "le Monstre " + nom + " a " + life + " et possède " + money + " est il endormis : " + awake;
  window.alert(etat);
}
window.addEventListener('onload', function() {
        let ne = prompt(" Donner le nom"," ");
        let le = prompt(" Donner la vie"," ");
        let me = prompt(" Donner de l'argent"," ");
        init(ne,le,me);
        showme();
    }
  );
