define(['angular', 'services'], function (angular) {
    'use strict';

    /* Controllers */

    /*
      modulariseren.
    */

    return angular.module('myApp.controllers', ['myApp.services'])
        // Sample controller where service is being used
        .controller('control1', ['$scope', 'version', function ($scope, version) {

            // zoveel mogelijk globals eruit halen.
            // dit ding moet als object gaan gedragen en meegeven.
            // zorgen dat dit niet losstaat.
            var declared = [];

            var isDeclared = function(k,v) {
                var result = $.grep(declared, function(e) { return e[k] == v; });
                if(result.length) {
                    return result[0];
                }
                return false;
            }

            // Closure to check if an expression is correct, i.e. has congruent data types.

            var operatorCheck = function(parentObject) {

                var checkObject = function(d) {

                    // check left and right
                    if(d.left instanceof Object) {
                        
                        if(!checkObject(d.left)) {
                            return false;
                        }

                    } else {
                        // is constant
                        if(!checkConstant(d.left)) {
                            return false;
                        }
                    }

                    if(d.right instanceof Object) {
                        
                        if(!checkObject(d.right)) {
                            return false;
                        }

                    } else {
                        // is constant

                        if(!checkConstant(d.right)) {
                            return false;
                        }
                    }

                    return true;

                }

                var checkConstant = function(child) {

                    // cannot refer to self
                    if(child == parentObject.name) {
                        $scope.messaging(parentObject.name + ' heeft een cyclische referentie naar zichzelf.');
                        return false;
                    }

                    // cannot be undefined
                    var childObject = isDeclared('name', child);

                    if(childObject == false) {
                        $scope.messaging(parentObject.name + ' heeft een ongedefinieerde value ' + child);
                        return false;
                    }

                    // must be same datatype    
                    if(parentObject.decltype != childObject.vartype) {
                        $scope.messaging(childObject.name + ' in ' + parentObject.name + ' heeft een incongruent datatype (' + childObject.vartype + ') - moet datatype ' + parentObject.decltype + ' zijn.');
                        return false;   
                    }

                    return true;

                }


                var check = function() {

                    var obj = parentObject.value;

                    if(obj instanceof Object) {
                        
                        // needs traversing
                        return checkObject(obj);

                    } else {
                        
                        // is constant
                        return checkConstant(parentObject.value);

                    }

                    return true;

                }

                return check();

            }

            var objectList = {
                /*
                'Form': function(o) {
                    
                    if(!isDeclared('type', 'Form')) {

                        declared.push({
                            'type': 'Form',
                            'name': o.name
                        });

                    } else {
                        $scope.messaging('Form is al declared');
                    }

                },
                */
                'Declaration': function(o) {
                    
                    if(isDeclared('name', o.name)) {
                        $scope.messaging(o.name + ' is al declared');
                        return;
                    }

                    // check possible pre-filled value
                    if('value' in o) {

                        // check is value is OK
                        if(!operatorCheck(o)) {
                            return;
                        }

                    }

                    declared.push({
                        'type': 'Variable',
                        'name': o.name,
                        'vartype': o.decltype
                    });



                },

                'Expression$': function(o) {
                    
                    console.log('expression: ', o);

                    // determine if types of operator are equivalent
                    if('operator' in o) {
                        //


                    }
                },


            }

            var traverseTopDown = function(o, f) {
                
                for (var prop in o) {
                           
                    // value
                    var obj = o[prop];  

                    if(prop == 'type') {

                        // search for index
                        for (var p in f) {
                            if(RegExp(p).test(obj)) {
                                f[p](o);
                            }
                        }

                    }

                    if(obj instanceof Array) {
                        // is array

                        for(var item in obj) {
                            traverseTopDown(obj[item], f);
                        }

                    } else if(obj instanceof Object) {
                        // is object
                        traverseTopDown(obj, f);
                    }

                }

            }

            $scope.failed = false;
            $scope.failedMessage = 'General failure';

            $scope.messaging = function(m) {
                $scope.messages += '\n';
                $scope.messages += m;
            }

            $scope.parse = function() {

                $scope.messages = '';
                declared = [];

                var parsed;
                
                try {

                    parsed = ps.parse($scope.input);
                    $scope.failed = false;

                } catch(e) {

                    $scope.failed = true;
                    $scope.ast = '';
              
                    if(e instanceof ps.SyntaxError) {
                        $scope.failedMessage = 'Cannot parse input language.';
                    } else {
                        $scope.failedMessage = 'General failure.';
                    }

                }

                $scope.output = parsed;

                $scope.ast = JSON.stringify(parsed, null, 4);

                // custom traverse tool

                if(!(parsed instanceof Object)) {
                    $scope.failedMessage = 'Cannot parse object.';
                }

                // traverse through object properties
                // 
                traverseTopDown(parsed, objectList);

                $scope.declared = JSON.stringify(declared, null, 4);

            }

        }])
});