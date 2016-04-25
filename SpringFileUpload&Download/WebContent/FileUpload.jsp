<!DOCTYPE html>
<html>
<head>
  <title>File Upload Example using AngularJS</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
</head>
<script type="text/javascript">

 var myApp = angular.module('uploadApp', []);

    myApp.controller('uploadController', function ($scope) {

        // GET THE FILE INFORMATION.
        $scope.getFileDetails = function (e) {

            $scope.files = [];
            $scope.$apply(function () {

                // STORE THE FILE OBJECT IN AN ARRAY.
                for (var i = 0; i < e.files.length; i++) {
                    $scope.files.push(e.files[i]);
                }

            });
        };

        // NOW UPLOAD THE FILES.
        $scope.uploadFiles = function () {

            //FILL FormData WITH FILE DETAILS.
            var data = new FormData();

            for (var i in $scope.files) {
                data.append("file", $scope.files[i]);
				console.log($scope.files[i]);
            }

            // ADD LISTENERS.
            var objXhr = new XMLHttpRequest();
            objXhr.addEventListener("progress", updateProgress, false);
            objXhr.addEventListener("load", transferComplete, false);

            // SEND FILE DETAILS TO tHE API.
           objXhr.open("POST", "/SpringFileUpload_Download/Testupload.htm");
            objXhr.send(data);
        }

        // UPDATE PROGRESS BAR.
        function updateProgress(e) {
            if (e.lengthComputable) {
                document.getElementById('pro').setAttribute('value', e.loaded);
                document.getElementById('pro').setAttribute('max', e.total);
            }
        }

        // CONFIRMATION.
        function transferComplete(e) {
            alert("Files uploaded successfully.");
        }
    });	
</script>
<body ng-app="uploadApp">

    <div ng-controller="uploadController" >
           <p><progress id="pro" value="0"></progress></p>
     <div class="form-group  form-horizontal">
        <input type="file" id="file" name="file" multiple
            onchange="angular.element(this).scope().getFileDetails(this)" class="input-file"/>

	 </div>
		<div class="col-md-4">
        <input type="button" ng-click="uploadFiles()" value="Upload"  class="btn btn-primary"/>

</div>
        <!--ADD A PROGRESS BAR ELEMENT.-->
 
    </div>

</body>