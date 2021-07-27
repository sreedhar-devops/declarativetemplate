pipeline {
  agent { label 'master' }
  stages {
         stage("smoketest") {   
             when {
                expression { DEPLOY_ENV ==~ '(qa1|qa2)'}
             }  
             environment {
                credsfordownsteamjob = credentials('credsfordownsteamjob')
                Deploy_Env = "${DEPLOY_ENV}"
                SmokeTest = "${SmokeTest}"       
             }              
             steps {     
                 script{
                    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'credsfordownsteamjob', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                        //   sh """
                        //  echo  uname=$USERNAME pwd=$PASSWORD
                        //  """   
                        //  sh ' echo $PASSWORD '
                        //  echo "user name is $USERNAME"
                        //var1.smoketestfun(USERNAME1, $PASSWORD1)
                        sh 'chmod 777 smoketest_automationscript.sh'
                        sh './smoketest_automationscript.sh' 
                    } 
                  }
             }
         }    
   }
}
