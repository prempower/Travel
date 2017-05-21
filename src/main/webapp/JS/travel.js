angular.module('travel', [])
.controller('ClientControl', function($scope, $http){
		var clientList = this; 
		clientList.clients = [
		      {fname:'Prem', lname:'Anand', state:'Tamil Nadu', country:'India', done:true},
		      {fname:'Prem', lname:'Nandhini', state:'Telengana', country:'India', done:false}];
	
	    clientList.customerList =[{firstName:'Prem', lastName:'Anand', homeState:'Tamil Nadu', homeCountry:'India'}];
	    

	

		clientList.addClient = function() {
			clientList.clients.push({fname:clientList.fname,lname:clientList.lname,state:clientList.state,country:clientList.country, done:false});
			alert('about to call');
			var urlStr = 'http://localhost:8080/SpringJPAExample/rest/client/fname/'+clientList.fname+'/lname/'+clientList.lname+'/state/'+clientList.state+'/country/'+clientList.country;
			clientList.fname = '';
			clientList.lname = '';
			clientList.state ='';
			clientList.country='';

			$http.put(urlStr)
	            .then(function (data, status, headers) {
	                $scope.ServerResponse = data;
	                
	                var url2 = 'http://localhost:8080/SpringJPAExample/rest/client/clients'; 
			        $http.get(url2).then(function (response){

			    	
			    	$scope.clientList.customerList=eval(response.data);
			    	
			    	});
	  		  	 
	            })
	            
	     
		      
		      
		    };
		    
		    
			clientList.removeClient = function() {

				var urlStr = 'http://localhost:8080/SpringJPAExample/rest/client/fname/'+clientList.firstName+'/lname/'+clientList.lastName;
				clientList.firstName = '';
				clientList.lastName = '';
		

				$http.post(urlStr)
		            .then(function (status, headers) {
		            	
					  	  var url3 = 'http://localhost:8080/SpringJPAExample/rest/client/clients'; 
					      $http.get(url3).then(function (response){

					    	
					    	$scope.clientList.customerList=eval(response.data);
					    	
					    	});
		              
		            })

			      
			    };
		    
		 
		    clientList.remaining = function() {
		      var count = 0;
		      angular.forEach(clientList.clients, function(client) {
		        count += client.done ? 0 : 1;
		      });
		      return count;
		    };
		 
		    clientList.archive = function() {
		      var oldClients = clientList.clients;
		      clientList.clients = [];
		      angular.forEach(oldClients, function(client) {
		        if (!client.done) clientList.clients.push(client);
		      });
		    };
		    
		    clientList.remove=function ($index,client){
	            if(client.done){
		    	clientList.clients.splice($index, 1);
	            }
		    };
		    
		    var url2 = 'http://localhost:8080/SpringJPAExample/rest/client/clients'; 
		    $http.get(url2).then(function (response){

		    	
		    	$scope.clientList.customerList=eval(response.data);
		    	
		    	});
		    
		   

	
});
	
