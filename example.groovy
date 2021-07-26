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
        //    def status = sh(script:'curl -u $credsfordownsteamjob_USR:$credsfordownsteamjob_PSW  http://localhost:8080/job/smoketestqa1/lastBuild/api/json|jq .building', returnStdout:true).trim()
        }
        else{

        }  
    }   
}

return this
