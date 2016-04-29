function Results($scope, $http) {
    $http.get('/api/results').success(function(data) {
        $scope.results = data;
        google.charts.load("current", {"packages": ["corechart"]});
        google.charts.setOnLoadCallback(function() { drawChart(data) });
    });
}

function drawChart(results) {
    var asArray = [["Political party", "Total votes"]].concat(results.map(function(row) {
        return [row.politicalParty.name, row.totalVotes];
    }));
    var data = google.visualization.arrayToDataTable(asArray);

    var options = {
        title: "Results chart"
    };

    var chart = new google.visualization.PieChart(document.getElementById("piechart"));

    chart.draw(data, options);
}


