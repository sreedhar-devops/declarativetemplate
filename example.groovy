def smoketestfun(String smoketestChoice, String deploymentEnvironment){
//    echo "${smoketestChoice}"
//    echo "${deploymentEnvironment}"
//    smokeTest="${smoketestChoice}"
    echo smokeTest
    echo DEPLOY_ENV
    if( smokeTest == "Yes" ) {
        if( !fileExists("/var/lib/jenkins/smoketest") ) {         
                sh 'mkdir -p /var/lib/jenkins/smoketest'
        } 
        if(DEPLOY_ENV == "qa1") {
            echo "inside qa1 if block"
            def status = sh(script:'curl -u $credsfordownsteamjob_USR:$credsfordownsteamjob_PSW  http://localhost:8080/job/smoketestqa1/lastBuild/api/json|jq .building', returnStdout:true).trim()
            if ( status == "true" ) {
                sh ''' echo 600 > /var/lib/jenkins/smoketest/delaysecondsqa1 '''
            } 
            else { 
                sh ''' echo " deploy env is $DEPLOY_ENV "  '''
                sh ''' curl -d "token=my-token&DEPLOY_ENV=$DEPLOY_ENV" -i -X POST "http://$credsfordownsteamjob_USR:$credsfordownsteamjob_PSW@localhost:8080/job/smoketestqa1/buildWithParameters" '''              
            }                        
        }
        else{

        }  
    }   
}

return this
