pipeline {
  agent { label 'master' }
  stages {
    stage("smoketest") {   
      when {
        expression { DEPLOY_ENV ==~ '(qa1|qa2)'}
      }  
      environment {
       // credsfordownsteamjob = credentials('credsfordownsteamjob')
        Deploy_Env = "${DEPLOY_ENV}"
        SmokeTest = "${SmokeTest}"
       
      }              
      steps {     
        script{
          def var1 = load "example.groovy"
          var1.smoketestfun(SmokeTest, Deploy_Env)
        }
      }
    }
    
  }
}
