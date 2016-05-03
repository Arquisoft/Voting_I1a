angular.module('results', [])
    .controller('Counting', ['$scope', '$http', ($scope, $http) => {
        // Seconds to refresh the results
        var INTERVAL = 10;
    
        $scope.secondsToUpdate = INTERVAL;  // Seconds left to update
        $scope.results = [];                // Results of the counting

        /**
         * Request the updated results to the service
         */
        $scope.requestResults = () => {
            $http.get('/api/results').success(data => {
                data = data.sort((a, b) => b.totalVotes - a.totalVotes);
                $scope.results = data;
                drawChart(data);
            });
        };

        /**
         * Update the state. Request the results if enough time has passed
         */
        var update = () => {
            if ($scope.secondsToUpdate > 0) {
                $scope.secondsToUpdate--;
                $scope.$apply();
                return;
            }
    
            $scope.requestResults();
            $scope.secondsToUpdate = INTERVAL;
            $scope.$apply();
        };

        $scope.forceUpdate = () => {
            $scope.secondsToUpdate = 1;
        };

        google.charts.load("current", {"packages": ["corechart"]});
        google.charts.setOnLoadCallback($scope.requestResults);
        setInterval(update, 1000);
}]);

function drawChart(results) {
    var asArray = [["Political party", "Total votes"]]
        .concat(results.map((row) => [row.politicalParty.name, row.totalVotes]));
    var data = google.visualization.arrayToDataTable(asArray);

    var options = {
        title: "Results chart"
    };

    var chart = new google.visualization.PieChart(document.getElementById("piechart"));

    chart.draw(data, options);
}


