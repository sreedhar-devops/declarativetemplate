pipeline {
  agent { label 'master' }
  stages {
    stage('test') {   
      steps {     
        script{
          def pipeline = load 'example.groovy'
          pipeline.test()
        }
      }
    }
    
    }
}
