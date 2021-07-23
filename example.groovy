def smoketestfun(String smoketestChoice, String deploymentEnvironment){
    echo "${smoketestChoice}"
    echo "${deploymentEnvironment}"
    if(${SmokeTest} == "Yes") {
        if( !fileExists("/var/lib/jenkins/smoketest") ) {         
                sh 'mkdir -p /var/lib/jenkins/smoketest'
        } 
    }   
}

return this
