pipeline {
    agent any
    parameters {
        string (name: 'Version' , defaultValue: '', description: 'Version to deploy on production')
        choice (name: 'Version_' , choices: ['1.1','1.2','1.3'], description: 'Version from choices')
        booleanParam (name: 'executeTests' , defaultValue: false, description: '')
    }
    environment {
        NEW_VERSION = '1.3.0'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building with Version ${NEW_VERSION}"
            }
        }
        stage('Test') {
            when {
                expression  {
                    params.executeTests == true
                }
            }
            steps {
                echo "Testing..."
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying with Version ${NEW_VERSION}..."
                echo "Deploying version ${params.Version}"
            }
        }
    }
}
