angular.module('voters', [])
    .controller('VoterController', ['$http', '$scope', ($http, $scope) => {
        $scope.email = "";
        $scope.password = "";

        // Info of the user when he logs in
        $scope.user = {};

        $scope.loginError = false;          // If there was an error at log in
        $scope.logged = false;              // If the user has been logged

        $scope.newPassword = "";
        $scope.newPasswordRepeat = "";

        $scope.changePwdError = false;      // If there was an error changing the password
        $scope.changePwdSuccess = false;    // If the password changing was successful

        /**
         * Verify the credentials of the user, and show is information in that case
         */
        $scope.login = () => {
            // Send the request with the credentials to the service
            $http.post('/voter/get_info', {
                email: $scope.email,
                password: $scope.password
            }).then(
                // If successful, update the model
                data => { $scope.user = data.data; $scope.loginError = false; $scope.logged = true; },

                // If not, set the error flag
                () => { $scope.loginError = true; }
            );
        };

        /**
         * Change the password of the logged user
         */
        $scope.changePassword = () => {
            // Check that the passwords match. If not, finish and show an error
            if ($scope.newPassword !== $scope.newPasswordRepeat) {
                $scope.changePwdError = true;
                return;
            }

            // Send the request to the server with the data to change the password
            $http.post('/voter/change_password', {
                email: $scope.email,
                oldPassword: $scope.password,
                newPassword: $scope.newPassword
            }).then(
                // Update the model if success
                () => { $scope.password = $scope.newPassword; $scope.changePwdSuccess = true; $scope.changePwdError = false; }
            );
        }
        
    }]);