// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  "use strict";
  window.addEventListener(
    "load",
    function() {
      initLocalStorage();

      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName("needs-validation");

      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function(form) {
        // si l'ur est creer-collab.html?errors
        if (window.location.search == "?errors") {
          form.classList.add("was-validated");
        }
        form.addEventListener(
          "submit",
          function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add("was-validated");
          },
          false
        );
      });
    },
    false
  );
})();

var createCollaborateurProcess = event => {
  event.preventDefault();
  // récupérer les valeurs saisies
  var nom = document.getElementById("input-nom").value.trim();
  var prenom = document.getElementById("input-prenom").value.trim();
  var adresse = document.getElementById("input-adresse").value.trim();
  var date = checkDate(document.getElementById("input-date").value);
  var secu = checkSecu(document.getElementById("input-secu").value);

  if (
    secu != null &&
    date != null &&
    nom != "" &&
    prenom != "" &&
    adresse != ""
  ) {
    console.log("Creation du colaborateur");
    var collab = {
      nom: nom,
      prenom: prenom,
      adresse: adresse,
      date: date,
      numeroSecu: secu,
      fonction: "inconnu",
      departement: "inconnu",
      telephone: "inconnu"      
    };
    addColab(collab, () => {
      redirectTo("/collaborateurs/editer?secu=" + collab.numeroSecu);
    });
  } else {
    redirectTo("/collaborateurs/creer?errors");
  }
};

var millisecondesEnAnnees = millisecondes => {
  const UNE_SECONDE_EN_MILLISECONDES = 1000;
  const UNE_MINUTE_EN_SECONDE = 60;
  const UNE_HEURE_EN_MINUTES = 60;
  const UN_JOUR_EN_HEURES = 24;
  const UNE_ANNEE_EN_JOURS = 365.25;

  return (
    millisecondes /
    UNE_SECONDE_EN_MILLISECONDES /
    UNE_MINUTE_EN_SECONDE /
    UNE_HEURE_EN_MINUTES /
    UN_JOUR_EN_HEURES /
    UNE_ANNEE_EN_JOURS
  );
};

// vérifier le format de la date
var checkDate = isoDate => {
  var date = new Date(isoDate);
  var age = Date.now() - date;
  if (millisecondesEnAnnees(age) > 18) {
    return isoDate;
  }
  return null;
};

// retourn null ou le bon numero de secu
var checkSecu = secu => {
  // est composé de 15 chiffres
  const SECU_LENGTH = 15;
  secu = secu.trim();
  // vérifier que le numero contient 15 chiffres
  if (secu.length == SECU_LENGTH && !Number.isNaN(Number(secu))) {
    return secu;
  }
  return null;
};

/*
    Initialise le local storage avec la structure de base
*/
var initLocalStorage = () => {
  var app = localStorage.getItem("app");
  if (!app) {
    app = {
      name: "SGP App",
      collaborateursList: [],
      statististiquesList: [],
      activitesList: []
    };
    localStorage.setItem("app", JSON.stringify(app));
  }
  return app;
};

/**
 * Ajouter un callaborateur au localstorage
 */
var addColab = (colab, callback) => {
  var app = JSON.parse(localStorage.getItem("app"));
  app.collaborateursList.push(colab);
  localStorage.setItem("app", JSON.stringify(app));
  callback();
  console.log("collabarateur ajouté");
};

/**
 * Rediriger vers une page
 */
var redirectTo = page => {
  window.location.href = page;
};

