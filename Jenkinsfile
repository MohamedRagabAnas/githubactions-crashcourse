def gv

pipeline {
    agent any
    tools {
        gradle 'Gradle-8.0'
    }
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

        stage ("Run Frontend") {
            steps {
                script {
                    echo "excuting yarn...."
                    nodejs('Node-10.17.0'){
                        sh 'yarn install'
                    }

                }
            }
        }


        stage ("Run Backend") {
            steps {
                script {
                    echo "excuting gradle...."
                    sh './gradlew -v'
                    

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
