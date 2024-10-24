@Library('jenkins-shared-library') _
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    sampleLibrary3.buildProject('maven') // Use Maven for build
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sampleLibrary3.runTests('gradle') // Use Gradle for tests
                }
            }
        }
    }

    post {
        success {
            script {
                sampleLibrary3.notifySuccess('#devops-channel')
            }
        }
        failure {
            script {
                sampleLibrary3.notifyFailure('#devops-channel')
            }
        }
    }
}
