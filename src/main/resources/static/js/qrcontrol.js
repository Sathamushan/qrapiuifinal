(function(angular) {
var myApp = angular.module('myApp', []);

myApp.controller('qrController', ['$scope', function($scope) { 
	$scope.lableclockName='Clock Off';
	$scope.loadLookUpCode = function(loadLookUpCode){
		if(loadLookUpCode!='N'){
			$scope.lableclockName='Clock On';
			$scope.clockin=true;
		}else{
			$scope.lableclockName='Clock Off';
			$scope.clockin=false;
		}
	}
	var scanner = new Instascan.Scanner({
	   video: document.getElementById('previewss'), scanPeriod: 5, mirror: false });
scanner.addListener('scan',function(content){
 //var test= content;  
	var clockin= true;
	 //var test="http://www.letslearnever.com/0001/1/1/A"; 
	 
	// var x = document.getElementById("clockoffOnValue.switch-input").value;
	 //alert(x);
	  //	$scope.title1 =content;
	  	var urllArray = content.split("/");
	  	var schoolCode = urllArray[3];
	  	var stdID = urllArray[4];
	  	var stdClass = urllArray[5];
	  	var stdSec=urllArray[6];
	  	
	  	if($scope.clockin==true){
	  		var url = "http://localhost:8080/smjh/attendance/insert";
	  		var data1 = {
    	  			"studentname":"",
    	  			"classe":stdClass, 
    	  			"section":stdSec ,
    	  			"studentid":stdID,
    	  			"schoolcode":schoolCode,
    	  			"attendancestatus":"present",
    	  			"clockontime": "",
    	  			"clockofftime":"",
    	  			"breaktime":"",
    	  			"durationminute":"",
    	  			"durationhours":"",
    	  			"currentdate":""
    	  	}
    	  	
	  	}else{
	  	var url = "http://localhost:8080/smjh/attendance/updateById/"+stdID;
	  	}
	  	
	  	var xhr = new XMLHttpRequest();
	  	xhr.open("POST", url, true);
	  	xhr.setRequestHeader('Content-Type', 'application/json');
	  	xhr.send(JSON.stringify(data1));
	  	xhr.onload = function() {
	  	    var data = JSON.parse(this.responseText);
	  	    console.log(data);
	  	};
	  //alert(content);
    //window.location.href=content;
});
Instascan.Camera.getCameras().then(function (cameras){
    if(cameras.length>0){
        scanner.start(cameras[0]);
        $('[name="options"]').on('change',function(){
            if($(this).val()==1){
                if(cameras[0]!=""){
                    scanner.start(cameras[0]);
                }else{
                    alert('No Front camera found!');
                }
            }else if($(this).val()==2){
                if(cameras[1]!=""){
                    scanner.start(cameras[1]);
                }else{
                    alert('No Back camera found!');
                }
            }
        });
    }else{
        console.error('No cameras found.');
        alert('No cameras found.');
    }
}).catch(function(e){
    console.error(e);
    alert(e);
});

}]);
})(window.angular);
