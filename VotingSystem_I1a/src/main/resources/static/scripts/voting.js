angular.module('voting', [])
    .controller('VotingController', ['$scope', '$http', ($scope, $http) => {

        $scope.politicalParties = [];
        
        $scope.email = "";
        $scope.password = "";
        $scope.politicalParty = {};

        $scope.voted = false;

        $scope.vote = () => {
            $http.post('/voting/vote', {
                voterEmail: $scope.email,
                voterPassword: $scope.password,
                politicalPartyId: parseInt($scope.politicalParty)
            }).success(() => { $scope.voted = true });
        };

        $http.get('/voting/candidates/').success(data => { $scope.politicalParties = data; });
    }]);