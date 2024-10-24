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
                    sampleLibrary2.sayHello('Said')
                    sampleLibrary2.buildProject()
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sampleLibrary2.runTests()
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
                    sampleLibrary2.deployToEnvironment(DEPLOY_ENV)
                }
            }
        }
    }

    post {
        success {
            script {
                echo 'Pipeline succeeded!'
                sampleLibrary2.notifySuccess()
            }
        }
        failure {
            script {
                echo 'Pipeline failed!'
                sampleLibrary2.notifyFailure()
            }
        }
        always {
            cleanWs()
        }
    }
}
