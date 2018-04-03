(function(){
    angular
        .module("LandmarkApp")
        .controller("MainController", MainController);

    function MainController(MainService, $location,$rootScope) {
        var vm = this;
        MainService
            .getsomedata()
            .then(
                function (response) {

                    console.log("Hello");

                }
            )

    }
})();