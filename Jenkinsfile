pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                sh 'ant -f build.xml -v' 
            }
        }
        stage('Test') { 
            steps {
               sh 'ant -f build.xml -v' 
            }
        }
        stage('Deploy') { 
            steps {
               sh 'ant -f build.xml -v' 
            }
        }
    }
}
