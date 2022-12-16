def gv

pipeline {
    agent any
    parameters {
        string (name: 'Version' , defaultValue: '2.3.0', description: 'Version to deploy on production')
        choice (name: 'Version_' , choices: ['1.1','1.2','1.3'], description: 'Version from choices')
        booleanParam (name: 'executeTests' , defaultValue: false, description: '')
    }
    environment {
        NEW_VERSION = '1.3.0'
    }
    stages {

        stage ("init") {
            steps {
                script {
                gv = load "script.groovy"
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    gv.buildAPP()
                }
            }
        }
        stage('Test') {
            when {
                expression  {
                    params.executeTests == true
                }
            }
            steps {
                script{
                    gv.testAPP()
                }
            }
        }
        stage('Deploy') {
            steps {
                 script{
                    gv.deployAPP()
                }      
            }
        }
    }
}
