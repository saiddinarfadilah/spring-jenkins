@Library('jenkins-shared-library') _
pipeline {
    agent any

    options {
        timeout(time: 30, unit: 'MINUTES')
        disableConcurrentBuilds()
    }

    environment {
        BUILD_ENV = 'sit'
        DEPLOY_ENV = 'sit'
    }

    stages {
        stage('Preparation') {
            steps {
                script {
                    echo "Starting pipeline for ${BUILD_ENV} environment"
                }
            }
        }

        stage('Build') {
            when {
                branch 'sit'
            }
            steps {
                script {
                    sampleLibrary.sayHello('Said')
                    sampleLibrary.buildProject()
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sampleLibrary.runTests()
                }
            }
        }

        stage('Deploy') {
            when {
                branch 'sit'
            }
            steps {
                script {
                    echo "Deploying to ${DEPLOY_ENV} environment"
                    sampleLibrary.deployToEnvironment(DEPLOY_ENV)
                }
            }
        }
    }

    post {
        success {
            script {
                echo 'Pipeline succeeded!'
                sampleLibrary.notifySuccess()
            }
        }
        failure {
            script {
                echo 'Pipeline failed!'
                sampleLibrary.notifyFailure()
            }
        }
        always {
            cleanWs()
        }
    }
}
