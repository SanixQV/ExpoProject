let name;
let life = 0;
let money;
let awake;
let intervHasard=12000;
let b1=document.querySelector("#b1");
let b2=document.querySelector("#b2");
let b3=document.querySelector("#b3");
let b4=document.querySelector("#b4");
let b5=document.querySelector("#b5");
let b6=document.querySelector("#b6");
let b7=document.querySelector("#b7");
let k=document.querySelector("#k");



function init(n,l,m){
  name=n;
  life=l;
  money=m;
  awake=true;
};

function showme(){
  let etat = "le Monstre " + name + " a " + life + "points de vie et possède " + money +"pieces d'or; est il réveillé : " + awake;
  log(etat);
};

window.addEventListener('load', function() {
        go();
    });



function go(){
  let nM = prompt(" Donner un nom au monstre"," ");
  let vM = prompt(" Donner les points de vie du monstre"," ");
  let aM = prompt(" Donner de l'argent au monstre"," ");
  init(nM,vM,aM);
  displayStatus(life, money, awake);
  b6.addEventListener('click', showme);
  b2.addEventListener('click', run);
  b3.addEventListener('click', fight);
  b7.addEventListener('click', work);
  b5.addEventListener('click', eat);
  b4.addEventListener("click",sleep);
  setInterval(hasard, intervHasard);
  b1.addEventListener('click', newLife);
  k.addEventListener('click', kill);
};


function log(message){
    let m=actionbox.firstChild;
    let newP = document.createElement('p');
    newP.textContent = message;
    actionbox.insertBefore(newP,m);
};
let newP1 = document.createElement('li');
let newP2 = document.createElement('li');
let newP3 = document.createElement('li');
let stat=document.querySelector("#status");
stat.removeChild(stat.firstChild);

function displayStatus(life,money,awake){
	for(let i=0;i<3;i++){
		stat.removeChild(stat.firstChild);
	}
	if(awake){
		newP3.textContent = "Awake";
	}else{
		newP3.textContent = "Asleep";
	}
	stat.insertBefore(newP3,stat.firstChild);
	newP2.textContent = "Money: "+money;
	stat.insertBefore(newP2,stat.firstChild);
    newP1.textContent = "Life: "+life;
	stat.insertBefore(newP1,stat.firstChild);


  let indicateur=document.querySelector("#monster");

	if(life>20){
		indicateur.style.backgroundColor='green';
	}
  else if((life<=20)&&(life>15)){
		indicateur.style.backgroundColor='green';
	}
  else if((life<=15)&&(life>10)){
		indicateur.style.backgroundColor='blue';
	}
  else if((life <= 10)&&(life>5)){
		indicateur.style.backgroundColor='orange';
	}
  else{
    indicateur.style.backgroundColor='red';
  }

	let bordure=money/5+"px";
	indicateur.style.borderStyle="solid";
	if(money>=100){
		indicateur.style.borderColor="gold";
	}else if((money<100)&&(money>=50)){
		indicateur.style.borderColor="silver";
	}else{
		indicateur.style.borderColor="brown";
	}
	indicateur.style.borderWidth=bordure;
	 indicateur.style.height=life+"px";

	 if(life<=0){
        b1.style.backgroundColor='blue';
        b2.style.backgroundColor='red';
        b3.style.backgroundColor='red';
        b4.style.backgroundColor='red';
        b5.style.backgroundColor='red';
        b6.style.backgroundColor='red';
        b7.style.backgroundColor='red';
        k.style.backgroundColor='red';
    }

    if(life>0){
        b1.style.backgroundColor='red';
        b2.style.backgroundColor='blue';
        b3.style.backgroundColor='blue';
        b4.style.backgroundColor='blue';
        b5.style.backgroundColor='blue';
        b6.style.backgroundColor='blue';
        b7.style.backgroundColor='blue';
        k.style.backgroundColor='blue';
    }
}

function run(){
  if(life == 1 && awake === true){ // ne marche pas avec un triple egale, je ne sais pas pourquoi.
    life = 0;
    log("Le Monstre entame sa course et trébuche sur un petit caillou, il se fait une fracture ouverte du tibia-péroné, en soit il n'est pas mort de ça, mais sur le chemin de l'hopital, il se fait désintégrer par un chasseur de l espace qui avait une dent contre lui, en effet il y a 10 ans le monstre à mangé sa fille en la confondant avec une tige de bambou");
    showme();
    displayStatus(life,money,awake);
  }
  else if (life > 1 && awake === true){
    life = life-1;
    log("Le monstre court, lentement, mais il court");
    showme();
    displayStatus(life,money,awake);
  }
  else if(life <= 0){
    log("Le monstre ne court pas car il est mort, et un mort ça ne court pas");
    showme();
    displayStatus(life,money,awake);
  }
  else if(awake===false){
    log("Le monstre ne court pas car il est endormis or il n'est pas somnambule");
    showme();
    displayStatus(life,money,awake);
  }
  };



  function fight(){
    if(life == 3 && awake === true){
      life = 0;
      log("Le Monstre entame son combat sur les chapeaux de roue, malheureusement la galette de ce midi est bien décidé a ressortir, son adversaire en profite pour lui asséner une blessure mortelle");
      showme();
      displayStatus(life,money,awake);
    }
    else if (life > 3 && awake === true){
      life = life-1;
      log("Le monstre se bat, une mandale à gauche, une mandale à droite et c'est la victoire, en fouillant son adversaire, il trouve une bourse");
      let bourse = Math.round(Math.random() * 10);
      for (let i = 0; i < bourse; i++){
        money++;
      };
      showme();
      displayStatus(life,money,awake);
    }
    else if(life <= 2 && life >0){
      log("Le monstre ne se bat pas car il sait quand il faut se retirer");
      showme();
      displayStatus(life,money,awake);
    }
    else if(awake===false){
      log("Le monstre ne se bat que dans son rêve");
      showme();
      displayStatus(life,money,awake);
    }else if(life < 1){
      log("Sa dernière battaile fut dévastatrice, si bien qu'il en est mort, il ne pourra plus se battre");
      showme();
      displayStatus(life,money,awake);
    }
  };

  function work(){
    if(life == 1 && awake == true){ // ne marche pas avec un triple egale, je ne sais pas pourquoi.
      life = 0;
      money++;
      money++;
      log("Le Monstre qui travaille en tant que charpentier est victime d'une chute de poutre, malheureusement il n'en survit pas");
      showme();
      displayStatus(life,money,awake);
    }
    else if (life > 1 && awake === true){
      life = life-1;
      money++;
      money++;
      log("Le monstre travaille et gagne un salaire de misère");
      showme();
      displayStatus(life,money,awake);
    }
    else if(life <= 0){
      log("Le monstre ne travaille pas car il est mort, et un mort ca ne travaille pas");
      showme();
      displayStatus(life,money,awake);
    }
    else if(awake===false){
      log("Le monstre ne travaille pas, malheureusement son réveil n'a encore pas sonné");
      showme();
      displayStatus(life,money,awake);
    }
  }


  function eat(){
    if(money < 3 && life > 0 &&  awake === true){
      log("Le monstre ne mange pas, il a du sécher les cours d'Alain longhais");
      displayStatus(life,money,awake);
      showme();
    }else if (money > 3 && life > 0 &&  awake === true){
      money --;
      money --;
      money --;
      life++;
      life++;
      log("Le monstre se rassasie de la galette de tata mireille");
      displayStatus(life,money,awake);
      showme();
    }else if (awake === false){
      log("Le monstre reve de la galette de tata mireille");
      displayStatus(life,money,awake);
    }else if (life < 1){
      log("Le monstre ne peut plus dévaliser le magasin de mireille car il est mort");
      displayStatus(life,money,awake);
    }

  }
  function sleep(){
  	if(life<1)
    	log("Le monstre est dors et déjà dans un sommeil eternel, malheureusement il ne peut en sortir");
        		displayStatus(life,money,awake);
    if (awake===false){
  			log("Le monstre dort deja ");
          		displayStatus(life,money,awake);
  		}

      if (awake === true && life >0){
  		awake=false;
  		log("Le monstre dort");
  		displayStatus(life, money, awake);
  		setTimeout(function(){ log("Le monstre se reveille, + 1pv");
  							life++;
  							awake=true;
  							displayStatus(life,money,awake); }, 7000);
  	}

  }
  function hasard(){
    let rand=Math.round(Math.random() * 4);
    switch (rand) {
      case 0:
        run();
        break;
      case 1:
        fight();
        break;
      case 2:
        work();
        break;
      case 3:
        sleep();
        break;
        case 4:
        eat();
        break;


    }
  }

  function kill(){
      let phrase;
      if(life>0){
          life=0;
             phrase=("Le monstre meurt");
      } else {
          phrase=("Aucun monstre n'est en vie");
          }
      log(phrase);
      displayStatus(life, money, awake);
  };

  function newLife(){
      let phrase;
      if(life===0){
             phrase=("Le monstre ressuscite");
             go();
      } else {
          phrase=("Un monstre est deja en vie");
          }
      log(phrase);
      displayStatus(life, money, awake);
  };
